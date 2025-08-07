package c250723oop.inner1;;

public class Police 
{
	private String name;
	private Gun gun;
	
	public Police(String name, Gun gun) 
	{
		this.setName(name);
		this.setGun(gun);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	// 멤버 클래스, 중첩 클래스, 내부 클래스
	// 사용 빈도가 낮다
	// 클래스 : 	필드 		데이터	private
	// 			메소드	코드		public
	//			생성자 	초기화	public
	//			중첩클래스	클래스소유	마음대로
	// 일반중첩클래스
	// static중첩클래스
	// 지역중첩클래스
	// 익명중첩클래스 - 중오
	private class Gun 
	{
	}
}