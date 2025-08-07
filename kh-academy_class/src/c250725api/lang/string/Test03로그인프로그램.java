package c250725api.lang.string;

import java.util.Scanner;

;

public class Test03로그인프로그램 
{
    public static void main(String[] args) 
    {
    	/*사용자에게 아이디와 비밀번호를 입력받아 다음과 같이 처리

아이디가 khacademy이고 비밀번호가 master인 경우 로그인 성공!이라는 메세지를 출력
그 외의 아이디와 비밀번호가 입력되는 경우에는 정보가 일치하지 않습니다라는 메세지를 출력*/
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("id를 입력하세요 : ");
    	String id = sc.next();
    	System.out.print("pw를 입력하세요 : ");
    	String pw = sc.next();
    	sc.close();
    	
    	if (id.equalsIgnoreCase("khacademy") && pw.equals("master")) 
    	{
    		System.out.println("로그인 성공!");
    	}
    	else 
    	{
    		System.out.println("정보가 일치하지 않습니다.");
    	}
    }
}