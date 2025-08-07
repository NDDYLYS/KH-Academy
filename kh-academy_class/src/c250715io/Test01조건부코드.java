package c250715io;

public class Test01조건부코드 
{
	public static void main(String[] args) 
	{
		// 조건이란?
		// - 상황에 따라 실행이 될 수도, 안 될 수도 있는 코드
		// - 상황은 항상 논리로 판정된다
		
		int number = 11;
		
		if (number % 2 == 1)
		{
			System.out.println("홀수");
		}
		else
		{
			System.out.println("짝수");
		}
	}
}