package c250716;

public class Test04삼육구게임 
{
	public static void main(String[] args) 
	{
		// 1부터 100 사이의 숫자 중에서 다음 규칙에 맞도록 숫자를 찾아 출력
		// 3 || 6 || 9를 가진 숫자를 찾아서 출력
		// 12짝45짝78짝10
		/*
		for(int i = 1; i <= 100; i++) 
		{
			int one = i % 10;
			int ten = i / 10;
			
			boolean hasOne = one == 3 || one == 6 || one == 9;
			boolean hasTen = ten == 3 || ten == 6 || ten == 9;
			
			if (hasOne || hasTen)
				System.out.println(i + "에는 3, 6, 9가 들어있습니다.");
		}
		*/
		for(int i = 1; i <= 100; i++) 
		{
			int one = i % 10;
			int ten = i / 10;
			
			boolean hasOne = one == 3 || one == 6 || one == 9;
			boolean hasTen = ten == 3 || ten == 6 || ten == 9;
			
			int applause = 0;
			if (hasOne)
				applause += 1;
			if (hasTen)
				applause += 1;
			
			if (applause == 0)
				System.out.println(i);
			else if (applause == 1)
				System.out.println("짝");
			else if (applause == 2)
				System.out.println("짝짝");
			else
				System.out.println("존재할 수 없음");
		}
	}
}