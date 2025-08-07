package c250716;

public class Test01스위치구문 
{
	public static void main(String[] args) 
	{
		// if는 무조건 좋나?
		// - 검사를 순서대로 하는 게 장점이자 단점
		// 모든 경우가 동일하게 
		int level = 6;
		
		if (level == 1) 
		{
			System.out.println("병아리");
		}
		else if (level == 2) 
		{
			System.out.println("토끼");
		}
		else if (level == 3) 
		{
			System.out.println("다람쥐");
		}
		else if (level == 4) 
		{
			System.out.println("여우");
		}
		else if (level == 5) 
		{
			System.out.println("늑대");
		}
		else
		{
			System.out.println("호랑이");
		}
	}
}