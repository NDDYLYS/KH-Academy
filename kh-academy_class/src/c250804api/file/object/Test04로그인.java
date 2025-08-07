package c250804api.file.object;

import java.util.Scanner;

public class Test04로그인 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pwd = sc.nextLine();
		sc.close();
		
		MemberUtils utils = new MemberUtils();
		utils.Load();
		
		utils.Login(id, pwd);
		
		if (utils.Login(id, pwd)) 
			System.out.println("로그인 성공");
		else
			System.out.println("정보 불일치");
    }
}