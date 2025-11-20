package com.kh.spring10.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.AccountDao;
import com.kh.spring10.dto.AccountDto;

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
					mediaType = "text/plain"//일반 글자
					, schema = @Schema(implementation = String.class)
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
						mediaType = "text/plain"//일반 글자
						, schema = @Schema(implementation = String.class)
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
}
