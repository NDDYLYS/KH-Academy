package c250723oop.keyword1;

public class Calculator 
{
	// static을 붙이면 인스턴스 없이 사용 가능
	public static int getPlus(int left, int right) 
	{
		return left + right;
	}
	
	// 생성자를 잠근다
	private Calculator() {}
}