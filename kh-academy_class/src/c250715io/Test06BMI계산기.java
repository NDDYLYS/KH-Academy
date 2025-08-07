package c250715io;

import java.util.Scanner;

public class Test06BMI계산기 
{
	public static void main(String[] args) 
	{
		/*
		 * 	사용자에게 신장과 체중을 각각 입력받아 BMI 수치를 계산하여 출력
			이 사용자가 과체중인지 판정하여 출력 (과체중 = BMI가 24.5 이상) 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("키를 입력해주세요.");
		float tall = sc.nextFloat();		
		
		System.out.print("체중를 입력해주세요.");
		float weight = sc.nextFloat();
		System.out.println("");
		
		float tall2 = tall / 100f;
		float bmi = weight / (float)Math.pow(tall2, 2);
		float overbmi = 24.5f;
		
		System.out.println("키가 " + tall + "cm이며 체중이 " + weight + "kg인 사람의 BMI 수치는 " + bmi + "이며 이는 과체중이 " + (overbmi <= bmi));
		
		
		sc.close();
	}
}