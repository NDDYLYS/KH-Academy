package c250724oop.inherit7;;

public abstract class Galaxy 
{
	private String number;
	private String color;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Galaxy(String number, String color) 
	{
		this.setNumber(number);
		this.setColor(color);
	}
	
	public abstract void show();
	public abstract void call();
	public abstract void sms();
	public abstract void samsungPay();
}