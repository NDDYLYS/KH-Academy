package c250724oop.inherit7;;

public class GalaxyFold7 extends Galaxy
{
	public GalaxyFold7(String number, String color) {
		super(number, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시폴드7 번호 : " + this.getNumber() + ", 색상 : " + this.getColor());
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시폴드7 전화 기능 실행");
	}

	@Override
	public void sms() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시폴드7 문자 기능 실행");
		
	}

	@Override
	public void samsungPay() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시폴드7 삼성페이 기능 실행");		
	}
	
	public void iris() {
		System.out.println("갤럭시폴드7 홍채인식 기능 실행");
	}
}