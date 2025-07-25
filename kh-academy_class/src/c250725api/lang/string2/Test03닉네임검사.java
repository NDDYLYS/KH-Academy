package c250725api.lang.string2;

import java.util.Scanner;

;

public class Test03닉네임검사 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 사용자가 입력한 닉네임이 다음 규칙에 부합하는지 검사하여 결과를 출력

		닉네임은 1~10글자 범위에서 작성해야함
		닉네임은 한글과 숫자로만 작성할 수 있음
		한글 중에서 ㅋㅋㅋ나 ㅡㅡ와 같은 자음 모음만 사용하는 것은 금지함
    	 * */
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("검사할 닉네임을 입력해주세요. : ");
    	String input = sc.next();
    	
    	String regex = "^[가-힣0-9]{1,10}$";
    
    	boolean match = input.matches(regex);
    	sc.close();
    	
    	if (match)
    		System.out.println("올바르다");
    	else
    		System.out.println("잘못");
    }
}