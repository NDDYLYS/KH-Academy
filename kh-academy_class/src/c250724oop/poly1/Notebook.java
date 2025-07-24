package c250724oop.poly1;;

public abstract class Notebook 
{
	public abstract void power();
	public abstract void video();
	public abstract void typing();
	
	public Notebook() {}
	
	public void execute(int command) 
	{
		switch(command) 
		{
		case 1: power(); break;
		case 2: video(); break;
		case 3: typing(); break;
		default: break;
		}
	}
}