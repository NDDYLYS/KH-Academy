package c250714;

import java.time.LocalDate;

public class Test07건강검잔대상자판정 
{
	public static void main(String[] args) 
	{
		// 30세 이상의 나이로 2년에 한 번마다
		// 짝수년도에 태어난 사람은 짝수해에 받는다
		// 홀수년에 태어난 사람은 홀수해에 받는다
		
		// 1981년생의 건강검진대상자판정 여부?
		 LocalDate now = LocalDate.now();
		
		int birth = 1981;
		int year = now.getYear();
		
		boolean adult = 30 <= (year - birth + 1);
		
		boolean bornEven = birth % 2 == 0;
		boolean bornOdd = birth % 2 != 0;
		boolean currentEven = year % 2 == 0;
		boolean currentOdd = year % 2 != 0;		
		
		boolean even = bornEven && currentEven;
		boolean odd = bornOdd && currentOdd;
		
		boolean condition1 = adult && even;
		boolean condition2 = adult && odd;
		
		boolean target = condition1 || condition2;
		
		System.out.println(target);
	}
}