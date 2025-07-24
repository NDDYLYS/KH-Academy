package c250717;


import java.util.Scanner;

;

public class Test02다이어트 
{
    public static void main(String[] args) 
    {
    	// 30일동안 진행
    	// 첫날은 푸시업 1개
    	// 다음나부터 전날보다 3개 더
    	// 일자별로 하는 푸시업 개수
    	// 30일동안 하는 푸시업 총갯수
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("얼마나 오래 하실 거에요? : ");
    	int period = sc.nextInt();
    	sc.close();
    	
    	int totalCount = 0;
    	int pushUpCount = 1;
    	for(int i = 0; i < period; i++) 
    	{
    		totalCount += pushUpCount;
    		System.out.println((i + 1) +  "일차 하는 푸시업 개수 : " + pushUpCount + "개");
    		pushUpCount += 3;
    	}
    	
    	System.out.println(period + "일동안 하는 푸시업의 총 개수 : " + totalCount + "개");
    }
}