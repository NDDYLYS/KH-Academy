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
    	
    	// YYYY-MM-DD 형식 정규식 작성
    	// 월 상관없이 무조건 31까지
    	// 월을 구분하여 28, 30, 31로 구분
    	// 윤년일 경우 29일로 표현
    	// String.substring()
    	// Integer.parseInt()
    	
    	// XXXX-(0[1-9]|1[0-2])-XX
    	String regex = "";
    
    	boolean match = input.matches(regex);
    	sc.close();
    	
    	if (match)
    		System.out.println("올바르다");
    	else
    		System.out.println("잘못");
    }
}