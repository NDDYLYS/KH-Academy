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
	
	@Operation
	(
		deprecated = true,
		description="회원가입을 위한 등록 기능",// 비추천 여부(사용 중지 예정이라면 true로 설정)
		responses= 
		{//예상되는 응답코드
				@ApiResponse(responseCode="200"), 
				@ApiResponse(responseCode="400"), 
				@ApiResponse(responseCode="500")
		}
	)
	
	@PostMapping("/")
	public void add(@Valid @RequestBody AccountDto accountDto) {
		accountDao.insert(accountDto);
	}
	
	//@GetMapping("/{accountId}")
	@GetMapping("/accountId/{accountId}")//커스텀 기능
	public boolean checkAccountId(@PathVariable String accountId) {
		AccountDto accountDto = accountDao.selectOne(accountId);
		return accountDto == null;
	}
	
	@GetMapping("/accountNickname/{accountNickname}")//커스텀 기능
	public boolean checkAccountNickname(@PathVariable String accountNickname) {
		AccountDto accountDto = accountDao.selectOneByAccountNickname(accountNickname);
		return accountDto == null;
	}
}
