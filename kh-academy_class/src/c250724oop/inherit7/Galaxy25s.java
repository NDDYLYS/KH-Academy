package c250724oop.inherit7;;

public class Galaxy25s extends Galaxy
{
	public Galaxy25s(String number, String color) {
		super(number, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시25s 번호 : " + this.getNumber() + ", 색상 : " + this.getColor());
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시25s 전화 기능 실행");
	}

	@Override
	public void sms() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시25s 문자 기능 실행");
	}

	@Override
	public void samsungPay() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시25s 삼성페이 기능 실행");
	}
	
	public void bixby() {
		System.out.println("갤럭시25s 음성인식 기능 실행");
	}
}