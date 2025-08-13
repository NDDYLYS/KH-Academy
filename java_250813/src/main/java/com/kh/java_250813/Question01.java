package com.kh.java_250813;

import java.util.Scanner;

public class Question01
{
	public static void main(String[] args) 
	{
		 Scanner sc = new Scanner(System.in);
		  
		 System.out.println("1부터 어디까지 더할까요?");
	     int number = sc.nextInt(); // sc.next가 아니라 sc.nextInt이어야 함
	  
	     sc.close();
	  
	     int total = 0; // 덧셈의 총합을 저장하는 변수는 처음에 0으로 시작해야 함
	     for(int i = 1; i <= number; i++) //  for 구문에서 i < number에 등호가 포함되어 ii <= number가 되어야 함
	     {  
	    	 total += i; // =+가 아니라 +=이어야 함
	     }
	  
	     System.out.println("1부터 " + number + "까지 더한 결과는 " + total + "입니다.");
	}
}