package c250715io;

import java.util.Scanner;

public class Test04평균계산기 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요.");
		int korean = sc.nextInt();
		
		System.out.println("영어 점수를 입력하세요.");
		int english = sc.nextInt();
		
		System.out.println("수학 점수를 입력하세요.");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		float avrg = (float)sum / 3;
		
		System.out.println("총점은 " + sum + "점이며, 평균은 " + avrg + "점입니다.");
		
		sc.close();
	}
}
