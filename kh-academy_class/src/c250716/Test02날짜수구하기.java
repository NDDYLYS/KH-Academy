package c250716;

import java.util.Scanner;

public class Test02날짜수구하기 
{
	public static void main(String[] args) 
	{
		// 큰달 : 1,3,5,7,8,10,12 -> 31
		// 작은달 : 4,6,9,11 -> 30
		// 2월은 운년이면 29, 평년이면 28일까지
		
		//사용자가 입럭한 숫자에 해당하는 달의 날짜수를 출력
		//사용자에게 연도와 월을 각각 입력 받아서 윤년을 고려하여 날짜수를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜를 입력해주세요(yyyymm) : ");
		int date = sc.nextInt();
		int year = date / 100;
		int month = date % 100;
		
		boolean leapYear = false;
		
		boolean leapYear1 = (year % 4 == 0);		
		boolean leapYear2 = (year % 100 == 0);
		boolean leapYear3 = (year % 400 == 0);
		
		leapYear = (leapYear3 || (!leapYear2 && leapYear1));
		
		int day;	
		
		switch (month) 
		{
		case 2 : day = (leapYear)? 29 : 28 ; break;
		case 4, 6, 9, 11 : day = 30; break;
		default : day = 31; break; // switch-case에 , 넣기 : 13버젼 이상
		}
		
		System.out.println(year + "년은 윤년 " + leapYear + "이며 " + month + "월은 " + day + "일까지 있습니다.");
	}
}