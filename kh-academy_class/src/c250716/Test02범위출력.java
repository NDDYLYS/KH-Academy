package c250716;

public class Test02범위출력 
{
	public static void main(String[] args) 
	{
		// 다음 주어진 범위의 숫자를 출력할 수 있도록 반복문
		
		// 1부터 100 사이의 홀수
		// 1부터 100 사이의 짝수
		// 1부터 100 사이의 3의 배수
		
		for(int i = 0; i <= 100; i++) 
		{
			if (i == 0)
				continue;
			boolean odd = i % 2 == 1; // 홀수
			if (odd)
				System.out.println("숫자 " + i + "은 홀수");
		}
		
		for(int i = 0; i <= 100; i++) 
		{
			if (i == 0)
				continue;
			boolean even = i % 2 == 0; // 짝수			
			if (even)
				System.out.println("숫자 " + i + "은 짝수");
		}
		
		for(int i = 0; i <= 100; i++) 
		{
			if (i == 0)
				continue;
			boolean triple = i % 3 == 0; // 3의 배수
			if (triple)
				System.out.println("숫자 " + i + "은 3의 배수");
		}
	}
}