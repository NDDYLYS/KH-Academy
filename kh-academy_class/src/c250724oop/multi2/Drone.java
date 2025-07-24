package c250724oop.multi2;;

public class Drone implements Electronic, Transportation, Flyable
{
	@Override
	public void onoff() 
	{
		System.out.println("드론의 전원을 켭니다 / 끕니다");
	}
	
	@Override
	public void move() 
	{
		System.out.println("드론가 이동합니다");
	}
	
	@Override
	public void fly() 
	{
		System.out.println("드론가 비행합니다");
	}
}