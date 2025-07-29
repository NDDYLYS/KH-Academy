package c250728api.exception;

public class Calculator 
{
	// 위험한 메소드
	// 이 메소드르 부르려면 반드시 플랜B를 준비하라
	// 예외 전가
	public static int div(int left, int right) throws Exception 
	{
		return left / right;
	}
}