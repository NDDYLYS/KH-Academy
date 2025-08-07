package c250718;

import java.util.Scanner;

;

public class Test01실행후반복 
{
    public static void main(String[] args) 
    {
    	// do-while
    	// do-while을 안 쓰는 이유
    	// 실행부터 하고 추가 반복 여부를 결정한다
    	
    	// 사용자에게 시험점수를 입력받게 하고 싶다
    	Scanner sc = new Scanner(System.in);
       	
    	int score = 0;
    	
    	
    	do 
    	{
    		System.out.print("입력 : ");
    		score = sc.nextInt();
    	}
    	while(0 < score || 100 < score);
    	
    	sc.close();
    	System.out.println("네 시험점수는 " + score + "입니다.");
    }
}