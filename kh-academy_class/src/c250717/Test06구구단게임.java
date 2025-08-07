package c250717;

import java.util.Random;
import java.util.Scanner;

public class Test06구구단게임 
{
    public static void main(String[] args) 
    {
    	// 사용자에게 10개의 무작위 구구단 문제를 출력하여 각 문제마다 정답을 입력 받도록 구현
    	// 10문제 출제 및 정답 입력이 끝나면 사용자가 맞춘 문제의 개수를 구하여 화면애 출력
    	// (+추가)연속해서 맞출 경우 콤보를 계산하여 화면에 출력
    	// 도구는 반복문 밖으로 작성
    	

    	Random r = new Random();
    	Scanner sc = new Scanner(System.in);
    	
    	int combo = 0;
    	int correct = 0; // 정답
    	int wrong = 0; // 오답
    	int count = 10;
    	
    	for(int i = 0; i < count; i++) 
    	{
    		int first = r.nextInt(8) + 2; // 2~9
    		int second = r.nextInt(9) + 1; // 1~9
    		
    		System.out.print(first + " X " + second + " = ");;
    		int answer = sc.nextInt();
    		
    		if (first * second == answer) 
    		{
    			correct ++;
    			combo ++;
    		} 
    		else 
    		{
    			wrong ++;
    			combo = 0;
    		}
    		
    		if (combo == 2)
    		System.out.println("2회 연속 정답! nice");
    		if (combo == 4)
        		System.out.println("4회 연속 정답! great");
    		if (combo == 6)
        		System.out.println("6회 연속 정답! perpect");
    		if (combo == 8)
        		System.out.println("8회 연속 정답! exellent");
    	}
    	
    	sc.close();
    	System.out.println(count + "개의 문제 출제 완료. 정답 : " + correct + "개, 오답 : " + wrong + "개");
    	
    }
}