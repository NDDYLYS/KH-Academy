package com.kh.spring10.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dto.AccountDto;
import jakarta.validation.Valid;

@CrossOrigin // CORS 해제
@RestController
@RequestMapping("/account")
public class AccountRestController {

	@PostMapping("/")
	public void add(@Valid @RequestBody AccountDto accountDto) {
		
	}
}
