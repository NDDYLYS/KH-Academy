package c250714;

public class Test05윤년판정 
{
	public static void main(String[] args) 
	{
		// 4년에 한 번 1일씩 추가
		// 100의 배수는 윤년애서 제외
		// 400의 배수는 무조건 윤년
		
		int year = 2024;
		
		boolean leapYear = false;
		
		boolean leapYear1 = (year % 4 == 0);		
		boolean leapYear2 = (year % 100 == 0);
		boolean leapYear3 = (year % 400 == 0);
		
		leapYear = (leapYear3 || (!leapYear2 && leapYear1));
		// 400의 배수이거나 4의 배수이지만 100의 배수가 아닐 때
		System.out.println(year + "년 / 윤년 : " + leapYear);
	}
}