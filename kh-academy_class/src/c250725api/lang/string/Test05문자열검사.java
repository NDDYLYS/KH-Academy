package c250725api.lang.string;;

public class Test05문자열검사 
{
    public static void main(String[] args) 
    {
    	// 문자열 검사
    	
    	String url = "https://www.naver.com";
    	System.out.println("url이 홈페이지의 주소인가?");
    	boolean aa = url.startsWith("https://");
    	
    	boolean bb = url.endsWith(".com");
    	
    	boolean cc = url.contains("naver");
    	
      	int d = url.indexOf("naver");
    	int ge = url.lastIndexOf("naver");
    	
    	char last = url.charAt(url.length() - 1);
    	
    	// 첫 글자가 소문자인지 판정
    	String asd = url.substring(0).toLowerCase();
    	System.out.println(asd);
    	
    	//boolean lower = 'a' <= url && url <= 'z';
    }
}