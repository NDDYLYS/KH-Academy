package c250724oop.multi2;;

public class Airplane implements Transportation, Flyable, Reserve
{
	@Override
	public void move() 
	{
		System.out.println("비행기가 이동합니다");
	}
	
	@Override
	public void fly() 
	{
		System.out.println("비행기가 비행합니다");
	}
	
	@Override
	public void resetvation() 
	{
		System.out.println("비행기를 예약합니다");
	}
}