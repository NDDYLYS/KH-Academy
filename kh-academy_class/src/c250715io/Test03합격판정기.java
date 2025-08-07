package c250715io;

import java.util.Scanner;

public class Test03합격판정기 
{
	public static void main(String[] args) 
	{
		// 한 번에 두 개의 과목을 평가
		// 두 과목의 평균을 구함
		// 각 과목이 40점 이상이면서 평균이 60점 이상
		// 합격이 아니라면 불합격 및 재평가 실시
		
		// 사용자에게 두 과목의 점수를 입력 받아 합격 또는 불합격을 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 과목의 점수를 입력해주세요. : ");
		int class_a = sc.nextInt();
		
		System.out.print("두 번째 과목의 점수를 입력해주세요. : ");
		int class_b = sc.nextInt();
		
		sc.close();
		
		int solo_target = 40;
		int avr_target = 60;
		
		boolean passed;
		
		float avr = (float)(class_a + class_b) / 2;
		
		if (avr_target <= avr)
		{
			if (solo_target <= class_a && solo_target <= class_b)
			{
				passed = true;
			}
			else 
			{
				passed = false;
			}
		}
		else 
		{
			passed = false;
		}
		
		System.out.println("두 과목의 평균은 " + avr + "점이며 합격여부는 " + passed + "입니다.");
	}
}
