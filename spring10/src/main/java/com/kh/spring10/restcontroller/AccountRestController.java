package com.kh.spring10.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.AccountDao;
import com.kh.spring10.dao.AccountTokenDao;
import com.kh.spring10.dto.AccountDto;
import com.kh.spring10.error.TargetNotfoundException;
import com.kh.spring10.error.UnauthorizationException;
import com.kh.spring10.service.TokenService;
import com.kh.spring10.vo.AccountLoginResponseVO;
import com.kh.spring10.vo.AccountRefreshVO;
import com.kh.spring10.vo.TokenVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="회원관리 컨트롤러")

@CrossOrigin // CORS 해제
@RestController
@RequestMapping("/account")
public class AccountRestController {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AccountTokenDao accountTokenDao;
//	
//	@Operation
//	(
//		deprecated = false,
//		description="회원가입을 위한 등록 기능",// 비추천 여부(사용 중지 예정이라면 true로 설정)
//		responses= 
//		{//예상되는 응답코드
//				@ApiResponse(responseCode="200"), 
//				@ApiResponse(responseCode="400"), 
//				@ApiResponse(responseCode="500")
//		}
//	)
//	
//	@Operation
//	(
//		deprecated = false,
//		description="회원가입을 위한 아이디 중복 검사 기능",// 비추천 여부(사용 중지 예정이라면 true로 설정)
//		responses= 
//		{//예상되는 응답코드
//			@ApiResponse(responseCode="200"), 
//			@ApiResponse(responseCode="500")
//		}
//	)
	
	@PostMapping("/")
	public void add(@Valid @RequestBody AccountDto accountDto) {
		accountDao.insert(accountDto);
	}
	
	@Operation(
		deprecated = false//비추천 여부(향후 사용 중지 예정이라면 true를 작성)
		, description = "회원 가입 시 사용할 아이디 중복검사 기능"//기능에 대한 설명
		, responses = {//예상되는 응답 코드
			@ApiResponse(
					responseCode = "200"//상태코드
					, description = "검사 성공"//설명
					, content = @Content(//결과 메세지의 형태 및 샘플
						mediaType = "text/plain"//일반 글자
						, schema = @Schema(implementation = Boolean.class)
						, examples = {
							@ExampleObject(value = "true"),
							@ExampleObject(value = "false")
						}
					)
			),
			@ApiResponse(
				responseCode = "500"//상태코드
				, description = "서버 오류"//설명
				, content = @Content(//결과 메세지의 형태 및 샘플
					//mediaType = "text/plain"//일반 글자
					schema = @Schema(implementation = String.class)
					, examples = {
						@ExampleObject(value = "server error")
					}
				)
			)
		}
	)
	
	//@GetMapping("/{accountId}")
	@GetMapping("/accountId/{accountId}")//커스텀 기능
	public boolean checkAccountId(@PathVariable String accountId) {
		AccountDto accountDto = accountDao.selectOne(accountId);
		return accountDto == null;
	}
	
	@Operation(
			deprecated = false//비추천 여부(향후 사용 중지 예정이라면 true를 작성)
			, description = "회원 가입 시 사용할 닉네임 중복검사 기능"//기능에 대한 설명
			, responses = {//예상되는 응답 코드
				@ApiResponse(
						responseCode = "200"//상태코드
						, description = "검사 성공"//설명
						, content = @Content(//결과 메세지의 형태 및 샘플
							mediaType = "text/plain"//일반 글자
							, schema = @Schema(implementation = Boolean.class)
							, examples = {
								@ExampleObject(value = "true"),
								@ExampleObject(value = "false")
							}
						)
				),
				@ApiResponse(
					responseCode = "500"//상태코드
					, description = "서버 오류"//설명
					, content = @Content(//결과 메세지의 형태 및 샘플
						//mediaType = "text/plain"//일반 글자
						schema = @Schema(implementation = String.class)
						, examples = {
							@ExampleObject(value = "server error")
						}
					)
				)
			}
		)
	
	@GetMapping("/accountNickname/{accountNickname}")//커스텀 기능
	public boolean checkAccountNickname(@PathVariable String accountNickname) {
		AccountDto accountDto = accountDao.selectOneByAccountNickname(accountNickname);
		return accountDto == null;
	}
	
	//@GetMapping("/accountId/{accountId}/accountPw/{accountPw}")
	@PostMapping("/login")
	public AccountLoginResponseVO login(@RequestBody AccountDto accountDto) {
		AccountDto findDto = accountDao.selectOne(accountDto.getAccountId());
		if (findDto == null)
			throw new TargetNotfoundException("존재하지 않는 계정");
		
		boolean valid = passwordEncoder.matches(accountDto.getAccountPw(), findDto.getAccountPw());
		
		if (valid == false)
			throw new TargetNotfoundException("로그인 인증 실패");
		
		return AccountLoginResponseVO.builder()
				.loginId(findDto.getAccountId())
				.loginLevel(findDto.getAccountLevel())
				.accessToken(tokenService.generateAccessToken(accountDto))
				.refreshToken(tokenService.generateRefreshToken(accountDto))
				.build();
	}
	
	@DeleteMapping("/logout")
	public void logout(@RequestHeader("Authorization") String bearerToken) {
		TokenVO tokenVO = tokenService.parse(bearerToken);
		accountTokenDao.deleteByTarget(tokenVO.getLoginId());
	}
	
	@PostMapping("/refresh")
	public AccountLoginResponseVO refresh(@RequestBody AccountRefreshVO accountRefreshVO) 
	{
		String refreshToken = accountRefreshVO.getRefreshToken();
		if (refreshToken == null) throw new UnauthorizationException();
		
		TokenVO tokenVO = tokenService.parse(refreshToken);
		boolean valid = tokenService.checkRefreshToken(tokenVO, refreshToken);
		if(valid == false) throw new TargetNotfoundException();
		
		return AccountLoginResponseVO.builder()
				.loginId(tokenVO.getLoginId())
				.loginLevel(tokenVO.getLoginLevel())
				.accessToken(tokenService.generateAccessToken(tokenVO))
				.refreshToken(tokenService.generateRefreshToken(tokenVO))
				.build();
	}
}
