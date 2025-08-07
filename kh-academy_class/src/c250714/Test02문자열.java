package c250714;

public class Test02문자열 
{
	public static void main(String[] args) 
	{
			String a = "Hello";
			
			System.out.println(a);
			System.out.println(a.length());
			System.out.println(a.toUpperCase());
			System.out.println(a.toLowerCase());
			
			String b = "hello" + 100;
			System.out.println(b);
			
			String d = "피자  떡볶이";
			String e = "피자\t떡볶이";
			System.out.println(d);
			System.out.println(e);
			
			String f = "피자\n떡볶이";
			System.out.println(f);
			
			String g = "나는 오늘 \"피자\"를 먹을거야";
			System.out.println(g);
	}
}