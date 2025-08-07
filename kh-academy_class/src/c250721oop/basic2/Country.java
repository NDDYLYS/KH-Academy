package c250721oop.basic2;

public class Country 
{
	// 멤버필드 > 클래스를 구성하는 기초 데이터 저장용 변수
	String name;
	String capital;
	long population;
	
	public Country(String _name, String _capital, long _population) 
	{
		name = _name;
		capital = _capital;
		population = _population;
	}
	
	public void PrintAll() 
	{
		System.out.println("국명 : " + name + ", 수도 : " + capital + ", 인구 : " + population);
	}
}