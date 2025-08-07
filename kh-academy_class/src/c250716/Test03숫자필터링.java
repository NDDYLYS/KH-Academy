package c250716;

public class Test03숫자필터링 
{
	public static void main(String[] args) 
	{
		//1부터 100 사이의 범위에서 5가 들어간 숫자를 골라서 출력
		for(int i = 1 ; i <= 100; i++) 
		{
			int one = i % 10;
			int ten = i / 10;
			
			if (one == 5 || ten == 5) 
			{
				System.out.println(i + "는 5가 들어갑니다.");
			}
		}
		
	}
}