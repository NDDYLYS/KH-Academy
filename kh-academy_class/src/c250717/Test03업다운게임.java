package c250717;

import java.util.Random;
import java.util.Scanner;

;

public class Test03업다운게임 
{
    public static void main(String[] args) 
    {
    	/*
    	업다운게임이란 컴퓨터가 미리 정답을 랜덤으로 정한 뒤 사용자가 이를 맞출 때까지 입력하는 게임입니다.
		정답이 아닐 경우 컴퓨터는 업 또는 다운이라는 힌트를 제공하게 되어 있습니다.
		
		업이라는 힌트는 사용자가 입력한 값보다 정답이 클 경우 제공합니다.
		다운이라는 힌트는 사용자가 입력한 값보다 정답이 작을 경우 제공합니다.
		
		정답을 입력하면 프로그램을 종료하면서 사용자에게 몇 번만에 맞췄는지 알려주세요.
		
		(+추가) 정답을 맞추기까지 걸린 시간을 측정하는 방법을 찾아서 적용시켜 보세요
    	 */
    	
    	Random r = new Random();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("게임을 시작합니다.");
    	
    	
    	int correct = r.nextInt(100) + 1;
    	System.out.println("숫자를 정했습니다. 맞춰보세요.");
    	long start = System.currentTimeMillis();
    	
    	try 
    	{
    		Thread.sleep(1000);
    	} 
    	catch (InterruptedException e) 
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	int count = 0;
    	while (true) 
    	{
    		int answer = sc.nextInt();
    		
    		if (correct == answer) 
    		{
    			break;
    		}
    		else 
    		{
    			count ++;
    			
    			// 오답
    			if (answer < correct) 
        		{
        			// 숫자를 낮게 말했을 떄
    		    	System.out.println("오답입니다. Up");
        		}
        		else
        		{
        			// 숫자를 높게 말했을 떄
        	    	System.out.println("오답입니다. Down");
        		}
    		}
    	}
    	
    	sc.close();
    	
    	long end = System.currentTimeMillis();
    	float gap = (end - start) / 1000L;
    	
    	System.out.println("정답입니다. " + count + "회의 시도로 "
    	+ gap + "초만에 정답을 맞췄습니다.");
    }
}