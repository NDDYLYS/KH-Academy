package c250717;

import java.util.Random;

;

public class Test05랜담구구단 
{
    public static void main(String[] args) 
    {
    	// 화면에 2단부터 9단 사이 중 하나를 랜덤으로 출력
    	
    	Random r = new Random();
    	
    	int first = r.nextInt(8) + 2; // 2~9
    	int second = r.nextInt(9) + 1; // 1~9
    	
    	System.out.println(first + " X " + second + " = " + first * second);;
    }
}