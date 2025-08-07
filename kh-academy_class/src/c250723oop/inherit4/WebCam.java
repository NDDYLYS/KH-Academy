package c250723oop.inherit4;;

public class WebCam extends Camera
{
	public void decorate() 
	{
		System.out.println(this.getName() + " 화면 꾸미기 기능 실행");
	}
}