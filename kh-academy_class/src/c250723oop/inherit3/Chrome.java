package c250723oop.inherit3;;

public class Chrome extends Browser
{
	public void develop() 
	{
		System.out.println(this.getUrl() + " 개발자 도구 기능 실행");
	}
	
	public void chromeStore() 
	{
		System.out.println(this.getUrl() + " 크롬스토어 기능 실행");
	}
}