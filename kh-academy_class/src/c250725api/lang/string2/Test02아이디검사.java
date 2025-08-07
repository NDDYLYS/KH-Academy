package c250725api.lang.string2;

import java.util.Scanner;

;

public class Test02아이디검사 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 사용자가 입력한 아이디가 다음 규칙에 부합하는지 검사하여 결과를 출력

			아이디는 5~20글자 이내로 작성해야함
			영문 소문자로 시작해야함
			두 번째 자리부터는 영문 소문자 또는 숫자, 대시(-), 언더스코어(_) 중 하나로 작성할 수 있음
    	 * */
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("검사할 아이디를 입력해주세요. : ");
    	String input = sc.next();
    	
    	String regex = "^[a-z][a-z0-9_\\-]{4,19}$";
    
    	boolean match = input.matches(regex);
    	sc.close();
    	
    	if (match)
    		System.out.println("올바르다");
    	else
    		System.out.println("잘못");
    }
}