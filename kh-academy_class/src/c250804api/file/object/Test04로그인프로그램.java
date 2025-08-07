package c250804api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

;

public class Test04로그인프로그램 
{
    public static void main(String[] args) 
    {
    	try 
    	{
    		Map<String, String> memberMap = new HashMap<>();
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.print("아이디를 입력해주세요 : ");
    		String id = sc.nextLine();
    		System.out.print("비밀번호를 입력해주세요 : ");
    		String pwd = sc.nextLine();
    		sc.close();
    		
    		File file = new File("files", "member.txt");
        	FileInputStream stream = new FileInputStream(file); // 출력통로
        	BufferedInputStream buffer = new BufferedInputStream(stream); // 임시저장
        	ObjectInputStream object = new ObjectInputStream(buffer); // 분해도구
        	
        	if (file.exists() && 0 < file.length())
        		memberMap = (Map<String, String>)(object).readObject();
        	
        	if (memberMap.containsKey(id)) 
        	{
        		
        		if (pwd.equals(memberMap.get(id))) 
        		{
        			System.out.println("로그인 성공");
        		}
        		else 
        		{
        			System.out.println("정보 불일치");        			
        		}
        	}
        	object.close();
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    }
}