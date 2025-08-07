package c250804api.file.object;

import java.io.IOException;
import java.util.Scanner;

public class Test03회원가입 
{
    public static void main(String[] args) throws IOException 
    {
    	// 가입할 정보 입력
    	// 파일에서 가입정보를 불러온다
    	// 가입 사능한지 검사
    	// 3번 결과에 따라 정보 추가하여 저장
    	
    	Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pwd = sc.nextLine();
		sc.close();
		
		MemberUtils utils = new MemberUtils();
		utils.Load();
		
		if (utils.CheckId(id)) 
		{
			System.out.println("이미 사용중인 아이디입니다");
			System.exit(0);
		}
		
		utils.AddUser(id, pwd);
		if (utils.Save())
			System.out.println("회원가입이 완료되었습니다.");
		else
			System.out.println("저장에 오류가 발생했습니다");
	}

	private static void Load() {
		// TODO Auto-generated method stub
		
	}
}