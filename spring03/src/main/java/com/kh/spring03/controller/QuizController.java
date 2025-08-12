package com.kh.spring03.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController 
{
	@RequestMapping("/quiz01")
	public String Quiz01(@RequestParam(required = false, 
	defaultValue = "0") int cream, 
			@RequestParam(required = false, 
	defaultValue = "0") int nutella) 
	{
		return "크림와플 : " + cream * 2500 + "원, "
				+ "누텔라와플 : " + nutella * 3500 + "원";
	}
	
	@RequestMapping("/quiz02")
	public String Quiz02(@RequestParam(required = false, 
	defaultValue = "2000") int year) 
	{
		int now = LocalDate.now().getYear();
		int koreanAge = now - year + 1;
		
		String subwayCategory = "";
		String subwayPrice;
		
		if (20 <= koreanAge && koreanAge <= 64) 
		{
			subwayCategory = "성인(20~64)";
			subwayPrice = "1550원";
		}
		else if (14 <= koreanAge && koreanAge <= 19) 
		{
			subwayCategory = "청소년(14~19)";
			subwayPrice = "900원";
		}
		else if (8 <= koreanAge && koreanAge <= 13) 
		{
			subwayCategory = "어린이(8~13)";
			subwayPrice = "550원";
		}
		else
		{
			subwayCategory = "어르신 및 영유아(65~ || ~7)";
			subwayPrice = "무료";
		}
		
		return year + "년 출생한 사람은 " + subwayCategory + "이며 지하철 요금은 " + subwayPrice + "입니다.";
	
	}
	
	@RequestMapping("/quiz03")
	public String Quiz03(@RequestParam double height, 
			@RequestParam double weight) 
	{
		double tall2 = height / 100f;
		double bmi = weight / Math.pow(tall2, 2);
		
		return "당신의 BMI 지수는 " + bmi + "입니다.";
	}
	
	@RequestMapping("/quiz04")
	public String Quiz04(@RequestParam int year) 
	{
		boolean leapYear = false;
		
		boolean leapYear1 = (year % 4 == 0);		
		boolean leapYear2 = (year % 100 == 0);
		boolean leapYear3 = (year % 400 == 0);
		
		leapYear = (leapYear3 || (!leapYear2 && leapYear1));
		return (leapYear)? "윤년입니다." : "평년입니다.";
	}
}
