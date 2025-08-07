package c250714;

import java.time.LocalDate;

public class A_1 
{
	public static void main(String[] args) 
	{
		// 20001005
		// year = / 10000
		// month =year % 10000 / 100
		// day / 100;
		
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		
		System.out.println(year + " / " + month);
	}
}