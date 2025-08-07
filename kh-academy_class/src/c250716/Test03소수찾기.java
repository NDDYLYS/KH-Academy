package c250716;

import java.util.Scanner;

public class Test03소수찾기 
{
	public static void main(String[] args) 
	{
/*
 * 	소수라는 것은 나눗셈으로 분할이 안되는 수를 말합니다.
	예를 들어서 9는 소수가 아닙니다. 
	이유는 3으로 분할되기 때문입니다 (3x3)
	
	6은 소수인가요? 아닙니다 (2x3 , 3x2)
	7은 소수입니까? 맞습니다 
	
	[소수의 정의] 1과 자기자신을 제외하고 나누어 떨어지지 않는 수
	
	소수는 암호학에서 아주 큰 의미가 있습니다(열쇠로 사용됨)
	따라서 우리 프로그램에서는 사용자가 입력한 어떤 숫자가 소수인지 아닌지 판정하여 출력하도록 구현
	
	(+추가) 단, 숫자가 커질 수록 성능이 현저하게 떨어질텐데 이 부분을 개선할 수 있는 아이디어도 고민해보세요.
 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("소수인지 판별하기 위해서 숫자를 하나 입력해주세요. : ");
		
		int number = sc.nextInt();
		sc.close();
		
		boolean isPrime = true; // 소수 여부
	
		if (number <= 1) 
		{
			// 1 이하의 수는 소수로 치지 않는다
			isPrime = false;
		}
		else if (number == 2) 
		{
			// 2는 소수이다
			isPrime = true;
		}
		else if (number % 2 == 0)  
		{
			// 짝수는 2 빼고 다 소수가 아니다
			isPrime = false;      
		}
		
		boolean progress = true;
		for(int n = 2; n < number; n++) 
		{
			// number 이하의 수 중 하나라도 나머지가 0이 있는 친구가 있으면 안됨
			if (number % n == 0) 
			{
				progress = false;
				isPrime = false;
			}
		}
		
		if (progress) 
		{
			// 나머지가 0인 친구가 단 하나도 없었다면 소수다\
			isPrime = true;
		}
		
		
        if (isPrime) 
        {
            System.out.println(number + "는 소수가 맞습니다.");
        }
        else 
        {
        	System.out.println(number + "는 소수가 아닙니다.");
        }
	}
}