package c250731api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03기억력테스트게임 
{
    public static void main(String[] args) 
    {
    	// 문자열을 계속 입력 받다가 같은 문자열이 나오면 종료
    	List<String> words = new ArrayList<>();
    	
    	try 
    	{
    		Scanner sc = new Scanner(System.in);
    		while(true) 
    		{
    			String input = sc.nextLine();
    			input = input.replace(" ", "");
    			input = input.replace("\t", "");
    			input = input.replace("\n", "");
    			input = input.replace("\r", "");
    			input = input.replace("\f", "");
    			input = input.replace("\u000B", "");
    			input = input.replace("\u00A0", "");
    			
    			if (!words.contains(input)) 
    			{  				
    				words.add(input);
    				System.out.println("새로운 단어 : " + input + " 입력!");
    			}
    			else 
    			{
    				sc.close();
    				
    				System.out.println(input + "은 입력한 적이 있습니다. 게임을 종료합니다.");
    				break;
    			}
    		}
    		
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    	
    	System.out.println("입력한 단어들 : " + words);
    	System.out.println("입력한 단어의 수 : " + words.size());
    }
}