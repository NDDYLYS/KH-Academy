package c250723oop.inherit3;

public class Whale extends Browser
{	
	public void papago() 
	{
		System.out.println(this.getUrl() + " 파파고 번역 기능 실행");
	}
	
	public void naverSearch() 
	{
		System.out.println(this.getUrl() + " 너이버 검색 기능 실행");
	}
}