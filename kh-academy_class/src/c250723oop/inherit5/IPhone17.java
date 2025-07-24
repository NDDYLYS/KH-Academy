package c250723oop.inherit5;;

public class IPhone17 extends IPhone
{
	public IPhone17(String number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	public void info() 
	{
		// number
		// super.number
		// this.number
	}
	
	//final은 재정의 금지
	//public final void applePay() 
	//{
	//	
	//}

	@Override
	public void applePay() 
	{
		System.out.println("IPhone17.applePay");
	}
}