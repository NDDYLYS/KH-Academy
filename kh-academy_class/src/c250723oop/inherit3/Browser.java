package c250723oop.inherit3;;

public class Browser 
{
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		System.out.println("URL 저장 " + url);
	}
	
	public void refresh() 
	{
		System.out.println(this.getUrl() + " 새로고침 기능 실행");
	}
	
	public void move() 
	{
		System.out.println(this.getUrl() + " 페이지 이동 기능 실행");
	}
}