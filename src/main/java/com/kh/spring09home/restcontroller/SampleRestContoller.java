package com.kh.spring09home.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin // 외부에서의 ajax 통신을 허용한다
@RestController
@RequestMapping("/rest/sample")
public class SampleRestContoller {
	@GetMapping("/hello")
	public String hello() 
	{
		return "hello AJAX!!!";
	}
}
