package c250804api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03회원가입프로그램 
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
        	FileOutputStream stream = new FileOutputStream(file); // 출력통로
        	BufferedOutputStream buffer = new BufferedOutputStream(stream); // 임시저장
        	ObjectOutputStream object = new ObjectOutputStream(buffer); // 분해도구
  
        	FileInputStream in_stream = new FileInputStream(file); // 출력통로
        	BufferedInputStream in_buffer = new BufferedInputStream(in_stream); // 임시저장
        	ObjectInputStream in_object = new ObjectInputStream(in_buffer); // 분해도구
        	
        	if (file.exists() && 0 < file.length())
        		memberMap = (Map<String, String>)(in_object).readObject();
        	else
        		memberMap = new HashMap<String, String>(); 
        	
        	if (0 < memberMap.size() && memberMap.containsKey(id)) 
        	{
        		System.out.println("이미 사용 중인 아이디입니다.");
        	} 
        	else 
        	{
        		System.out.println("회원 가입이 완료되었습니다.");
        		
        		memberMap.put(id, pwd);
            	object.writeObject(memberMap);            	
        	}
        	
        	object.close();
        	in_object.close();
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		//System.err.println(e.getMessage());
    	}
    }
}