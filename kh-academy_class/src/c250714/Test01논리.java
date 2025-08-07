package c250714;

public class Test01논리 
{
	public static void main(String[] args) 
	{
		// 프로그램으로 판정을 내리고 결과를 저장
		
		// 위와 같이 생년월일이 8자리 정수로 저장되어 있다고 할 때, 
		// 이 사람이 술/담배를 구매할 수 있는 성인인지 판정하여 성인이라면 true, 
		// 아니라면 false가 화면에 출력될 수 있도록 코드를 작성하세요.
		
		int birth = 20051012;
		int now = 20250714;
		
		int age = birth / 10000;
		int age2 = now / 10000;
		
		boolean adult = (age2 - age) >= 20;
		String adult2 = adult ? "맞습니다." : "아닙니다.";
		
		System.out.println(age + "년에 태어난 사람은 성인이 " + adult2);
	}
}