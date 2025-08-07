package c250801api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 
{
    public static void main(String[] args) 
    {
    	try 
	    {
    		Scanner sc =  new Scanner(System.in);
    		
	    	//throw new Exception("Error");
    		Map<String, String> id_repository = new HashMap<>();
    		id_repository.put("testuser1".toLowerCase(), "Testuser1!");
    		id_repository.put("testuser2".toLowerCase(), "Testuser2!");
    		id_repository.put("testuser3".toLowerCase(), "Testuser3!");
    		
    		System.out.print("로그인할 아이디를 입력해주세요 : ");
    		String input_id = sc.nextLine();
    		if (id_repository.containsKey(input_id.toLowerCase())) 
    		{
        		System.out.print("로그인할 패스워드를 입력해주세요 : ");
    			String input_pwd = sc.nextLine();
    			String password = id_repository.get(input_id.toLowerCase());
    			
    			if (input_pwd.equals(password)) 
    			{
    				System.out.println("로그인 성공.");
    			}
    			else 
    			{
    				System.out.println("정보가 일치하지 않습니다.");
    			}
    		}
    		else  
    		{
    			System.out.println("아이디가 존재하지 않습니다.");
    		}
    		
    		sc.close();
	    }
	    catch(Exception e) 
	    {
	    	System.err.println(e.getMessage());
	    }
    }
}