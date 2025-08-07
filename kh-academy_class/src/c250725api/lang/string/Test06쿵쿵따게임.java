package c250725api.lang.string;

import java.util.Scanner;

;

public class Test06쿵쿵따게임 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	String given = "토요일";
    	
    	while(true) 
    	{
    		System.out.println(given + "! 쿵쿵따!");
    		String input = sc.next();
    		
    		if (input.length() != 3)
    			break;
    		if (given.charAt(2) != input.charAt(0))
    			break;
    		
    		given = input;
    	}
    	
    	sc.close();
    	
    	System.out.println("Game Over");
    }
}