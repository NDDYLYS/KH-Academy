package c250716;

import java.util.Scanner;

public class Test03학점계산기 
{
	public static void main(String[] args) 
	{
		/*
		 * 100점 : A+
		90점 이상 100점 미만 : A
		80점 이상 90점 미만 : B
		70점 이상 80점 미만 : C
		70점 미만 : F
		
		모든 점수는 0 에서 100점 사이라고 할 때, 사용자에게 점수를 입력받아 학점을 출력하는 프로그램을 구현
		 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요. : ");
		
		String credit;
		int score = sc.nextInt();
		sc.close();
		/*
		if (100 <= score) 
		{
			credit = "A+";
		}
		else if (90 <= score && score < 100) 
		{
			credit = "A";
		}
		else if (80 <= score && score < 90) 
		{
			credit = "B";
		}
		else if (70 <= score && score < 80) 
		{
			credit = "C";
		}
		else
		{
			credit = "F";
		}
		*/
		
		int score2 = score / 10;
		switch(score2) 
		{
		case 10 : credit = "A+"; break;
		case 9 : credit = "A"; break;
		case 8 : credit = "B"; break;
		case 7 : credit = "C"; break;
		default : credit = "F"; break;
		}
		
		System.out.println("시험점수가 " + score + "점인 학생의 학점은 " + credit + "입니다.");
	}
}