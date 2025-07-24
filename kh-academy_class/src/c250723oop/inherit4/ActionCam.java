package c250723oop.inherit4;;

public class ActionCam extends MotionCam
{	
	public void reduce() 
	{
		System.out.println(this.getName() + " 흔들림 보정 기능 실행");
	}
}