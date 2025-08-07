package c250715io;

public class Test01표준출력명령 
{
	public static void main(String[] args) 
	{
		// 표준 출력 통로인 System.out을 쓰는 행위
		
		// println은 한 줄 출력하고 한 줄을 개행 처리
		System.out.println("Hello");
		// 개행 \n 캐리지 리턴 \r
		
		System.out.print("java");
		System.out.print(" - ");
		System.out.print("java");
		// print는 내부의 글자를 출력하고 후속 처리는 하지 않는다
		// 긴 데이터를 연속적으로 보여줘야 할 경우 사용
		
		System.out.println();
		System.out.printf("%d + %d = %d\n", 10, 20, 30);
		// printf는 C언어와 유사한 형태의 출력 방식

	}
}