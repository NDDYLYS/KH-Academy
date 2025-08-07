package c250725api.lang.string2;

import java.util.Scanner;

;

public class Test04숫자범위검사 
{
    public static void main(String[] args) 
    {
    	// 세 자리 정수 형식의 검사 방법?
    	Scanner sc = new Scanner(System.in);
    	System.out.print("검사할 정수를 입력해주세요. : ");
    	String input = sc.next();
    	System.out.println(input);
    	
    	String temp = input.substring(0, 4);
    	int year = Integer.parseInt(temp);
    	
    	String temp2 = input.substring(5, 7);
    	int month = Integer.parseInt(temp2);
    	// System.out.println(temp2);
    	// YYYY-MM-DD 형식 정규식 작성
    	// 월 상관없이 무조건 31까지
    	// 월을 구분하여 28, 30, 31로 구분
    	// 윤년일 경우 29일로 표현
    	// String.substring()
    	// Integer.parseInt()
    	
    	boolean leapYear = false;
		
		boolean leapYear1 = (year % 4 == 0);		
		boolean leapYear2 = (year % 100 == 0);
		boolean leapYear3 = (year % 400 == 0);
		
		leapYear = (leapYear3 || (!leapYear2 && leapYear1));
		String regex = "";

		switch(month) 
		{
		case 1 : 
		case 3 : 
		case 5 : 
		case 7 : 
		case 8 : 
		case 10 : 
			regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])$";
			break;
		case 4 : 
		case 6 : 
		case 9 : 
		case 11 : 
			regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|30)$";
			break;
		case 2 : 
			if (!leapYear)
				regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])$";
			else 
				regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9])$";
			break;
		}
    
    	boolean match = input.matches(regex);
    	sc.close();
    	
    	if (match)
    		System.out.println("올바르다");
    	else
    		System.out.println("잘못");
    	
    	// "^(19[0-9]{2}|20[0-9]{2})-((02-(0[1-9]|1[0-9]|2[0-"+lastNumber+"]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$";
    }
}