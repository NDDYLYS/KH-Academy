package c250717;

import java.util.Scanner;

;

public class Test02무한입력 
{
    public static void main(String[] args) 
    {
    	//0을 입력하면 프로그램을 종료하면서 현재까지 입력한 숫자와 합계, 평균을 출력하라
    	
    	Scanner sc = new Scanner(System.in);
    	float total = 0f;
    	int count = 0;
    	
    	while (true) 
    	{
    		System.out.print("숫자를 입력해주세요. 0을 입력하면 종료합니다. : ");
    		
    		int input = sc.nextInt();
    		if (input == 0)
    			break;
    		else 
    		{
    			total += input;
    			count ++;
    		}
    	}
    	
    	System.out.println("총합 : " + total);
       	System.out.println("평균 : " + (total / count));
    }
}