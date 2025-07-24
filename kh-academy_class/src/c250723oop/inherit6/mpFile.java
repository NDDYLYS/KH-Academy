package c250723oop.inherit6;;

public class mpFile extends File
{
	protected void forward()
	{
		System.out.println(this.getFilename() + " 빨리감기 기능");
	}
	
	protected void rewind()
	{
		System.out.println(this.getFilename() + " 되감기 기능");
	}
}