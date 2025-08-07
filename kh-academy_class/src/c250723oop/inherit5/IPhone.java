package c250723oop.inherit5;;

// super class
public class IPhone 
{
	// 멤버필드 - 접근제한이 문제
	protected String number;
	// private는 같은 클래스 내에서만 허용. 헷갈린다면 private.
	// protected는 같은 퍀키지 내 상속관계 허용. 약간 느슨해진다.
	
	// 생성자
	// 인스턴스를 만들 때 설정될 데이터를 강제한다
	// 여기서 만든 생성자를 상속받은 하위클래스는 무조건 따라가야 한다
	// 상위클래스의 생성자가 실행될 수 있도록 연계
	public IPhone(String number) 
	{
		this.number = number;
	}
	
	// 멤버메소드
	// 기능을 실행하기 위한 블록
	// 코드가 변경될 수 있는지 없는지를 파악하여 키워드로 명시
	public void applePay() 
	{
		System.out.println("IPhone.applePay");
	}
}