package c250724oop.multi2;;

public class Train implements Transportation, Reserve
{
	@Override
	public void move() 
	{
		System.out.println("기차가 이동합니다");
	}
	
	@Override
	public void resetvation() 
	{
		System.out.println("기차를 예약합니다");
	}
}