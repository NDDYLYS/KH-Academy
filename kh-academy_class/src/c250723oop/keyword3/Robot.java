package c250723oop.keyword3;

import java.time.LocalDate;

;

public class Robot 
{
	private Robot() {}
	
	public static void multiple(int a, int b) 
	{
		System.out.println(a + " * " + b + " = " + (a * b));
	}
	
	public static void square(int a) 
	{
		System.out.println(a + "^2 = " + (Math.pow(a, 2)));
	}
	
	public static void triangle(double a, double b) 
	{
		double temp = (a * b) / 2f;
		System.out.println("밑변 " + a + ", 높이 " + b + "인 삼각형의 넓이 : " + temp);
	}
	
	public static void circle(double r) 
	{
		double temp = r * r * Math.PI;
		System.out.println("반지름이 " + r + "인 원의 넓이 : " + temp);
	}
	
	public static void bmi(double a, double b) 
	{
		double temp = b / Math.pow(a / 100, 2);
		System.out.println("키 " + a + "cm, 체중 " + b + "kg인 사람의 체질량 지수 : " + temp);
	}
	
	public static void subway(int a) 
	{
		LocalDate now = LocalDate.now();

		int year = now.getYear();
		int koreanAge = year - a + 1;
		
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
		
		System.out.println(a + "년에 출생한 사람은 " + subwayCategory + "이며 지하철 요금은 " + subwayPrice + "입니다.");
	}
}