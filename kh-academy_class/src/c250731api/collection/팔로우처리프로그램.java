package c250731api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

;

public class 팔로우처리프로그램 
{
    public static void main(String[] args) 
    {
    	final String RESET = "\u001B[0m";
    	final String RED = "\u001B[31m";
    	final String BLUE = "\u001B[34m";
    	
    	List<String> ids = new ArrayList<>();
    	
	    try 
	    {
	    	Scanner sc = new Scanner(System.in);
	    	
	    	while(true) 
	    	{
	    		System.out.print("아이디를 입력해주세요 : ");;
	    		String id = sc.nextLine();
	    		
	    		if (id.equals("종료")) 
	    		{
	    			throw new Exception("종료합니다.");
	    		}
	    		
	    		if (!ids.contains(id)) 
	    		{
	    			ids.add(id);
	    			System.out.println(BLUE + "("+ id + ")" + RESET + "님을 팔로우하였습니다.");
	    		}
	    		else 
	    		{
	    			ids.remove(id);
	    			System.out.println(RED + "("+ id + ")" + RESET + "님을 언팔로우하였습니다.");
	    		}	
	    	}
	    	//throw new Exception("Error");
	    }
	    catch(Exception e) 
	    {
	    	System.err.println(e.getMessage());
	    }
	    
	    System.out.println("총 팔로우 인원은 " + ids.size() + "명입니다.");
    }
}