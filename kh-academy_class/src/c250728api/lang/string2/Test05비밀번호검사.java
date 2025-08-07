package c250728api.lang.string2;

import java.util.Scanner;

public class Test05비밀번호검사 
{
    public static void main(String[] args) 
    {
    	// 영문 대소문자, 숫자, 특수문자
    	// 글자 수 8~16자
    	// 영문 대문자
    	// 영문 소문자	
    	// 숫자
    	// 특수문자
    	
    	// "^(?=.*?[A-Z])[A-Za-z0-9\!\@\#\$\%\^\&\s]{8,16}$"
    	
    	//긍정 탐색 
		//- 반드시 1개 이상 포함되어야 하는 것을 정의(검사식 앞부분에 작성)
		//- 작성 방법 :     (?=검사코드)
		//부정 탐색
		//- 1개라도 포함되면 안되는 경우를 정의(검사식 앞부분에 작성)
		//- 작성 방법 :     (?!검사코드)
    	
    	// (?=.*?[A-Z])a
    	// (?=.*?[a-z])
    	// (?=.*?[0-9])
    	// 앞에 뭐가 나오든 뒤에 말하는 게 하나는 있어야 한다
    	
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("비밀번호를 입력해주세요. : ");
    	String input = sc.next();
    	sc.close();
    	
    	String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[\\!\\@\\#\\$\\%\\^\\&\\s])[A-Za-z0-9\\!\\@\\#\\$\\%\\^\\&\\s]{8,16}$";
    	
    	boolean match = input.matches(regex);
    	
    	if (match)
    		System.out.println("올바르다");
    	else
    		System.out.println("잘못");
    }
}