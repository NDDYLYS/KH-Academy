package c250716;

import java.util.Scanner;

public class Test02짝수홀수 
{
    public static void main(String[] args) 
    {
    	// 사용자에게 숫자 10개를 입력받아서 그 중 홀수와 짝수의 개수를 카운트한다
    	
    	Scanner sc = new Scanner(System.in); // 도구들은 반복에 포함시키지 않는다
    	int oddCount = 0;
    	int evenCount = 0;
    	
    	for(int i = 1; i <= 10; i++) 
    	{
    		System.out.print("10개의 숫자 중 " + i + "번째 숫자를 입력해주세요 : ");
    		int number = sc.nextInt();
    		
    		if (number % 2 == 1)
    			oddCount++;
    		else
    			evenCount++;
    	}
    	
    	sc.close();
    	
    	System.out.print("입력한 10개의 숫자 중 홀수는 " + oddCount + 
    			"개, 짝수는 " + evenCount + "개입니다.");
    }
}