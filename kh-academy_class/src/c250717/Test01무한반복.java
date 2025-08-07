package c250717;

import java.util.Random;

public class Test01무한반복 
{
    public static void main(String[] args) 
    {
    	// 무한반복
    	// 특정 시점까지 불규칙한 회수로 반복
    	// while
    	
    	Random r = new Random();
    	
    	while(true) 
    	{
    		int dice = r.nextInt(6) + 1;
    		
    		if (dice == 5)
    			break;
    	}
    }
}