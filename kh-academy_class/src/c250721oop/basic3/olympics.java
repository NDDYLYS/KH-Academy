package c250721oop.basic3;;

public class olympics 
{
	String name;
	String event;
	String division;
	
	int gold;
	int silver;
	int bronze;
	
	public olympics(String _name, String _event, String _division, int _gold, int _silver, int _bronze) 
	{
		name = _name;
		event = _event;
		division = _division;
		
		gold = _gold;
		silver = _silver;
		bronze = _bronze;
	}
	
	public void PrintAll() 
	{
		System.out.println("이름 : " + name + ", 종목 : " + event + ", 구분 : " + division + ", 금 : " + gold + ", 은 : " + silver + ", 동 : " + bronze);
	}
	
	public void PrintMedalScore() 
	{
		System.out.println(name + " 선수의 획득 점수는 " + (gold * 100 + silver * 10 + bronze * 1) + "점입니다.");
	}
}