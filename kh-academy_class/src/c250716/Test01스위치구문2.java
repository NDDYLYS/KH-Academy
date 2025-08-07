package c250716;

public class Test01스위치구문2 
{
	public static void main(String[] args) 
	{
		// switch-case
		// - 순차적 논리가 아니라 값을 이용하여 처리하는 조건문
		//  1,2,3,4,5,6에 동일한 실행 속도가 보장된다.
		int level = 7;
		
		
		switch(level) 
		{
		case 1 : System.out.println("병아리"); break;
		case 2 : System.out.println("토끼"); break;
		case 3 : System.out.println("다람쥐"); break;
		case 4 : System.out.println("여우"); break;
		case 5 : System.out.println("늑대"); break;
		case 6 : System.out.println("호랑이"); break;
		default : System.out.println("사자"); break;
		}
	}
}