package com.kh.spring03.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController 
{
	// 컨트롤러
	// - 사용자가 접속할 수 있는 페이지를 제공하는 도구
	// - 화면을 반환하는 Controller가 있고, 
	// - 데이터를 반환하는 RestController가 있다
	// - 개발자가 직접 생성하는 것이 아니라 스프링한테 만들어 달라고 한다
	// - 스프링이 시작과 동시에 만들어서 보관
	// - @Controller 또는 @RestController를 상단에 붙인다
	// - 이를 inversion of control, 제어 반전이라고 한다(스프링의 제 1특징)
	
	// 실제로 접속하여 결과를 내놓는 매핑을 추가할 수 있다
	// @RequestMapping 키워드를 메소드 상단에 추가
	// 메소드는 사용자가 받을 내용을 내보내면 된다
	// 주소는 http://localhost:8080 뒤에 올 값을 작성
	@RequestMapping("/hello")
	public String hello() 
	{
		return "hello";
	}
	
	// 원하는 개수만큼 매핑 생성 가능, 단 주소는 유일해야 한다
	@RequestMapping("/hello22")
	public String hello22() 
	{
		return "hello22";
	}
	
	@RequestMapping("/dice")
	public String dice() 
	{
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		return "DICE" + dice;
	}
}
