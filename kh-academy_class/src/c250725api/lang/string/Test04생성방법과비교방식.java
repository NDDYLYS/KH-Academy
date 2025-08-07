package c250725api.lang.string;;

public class Test04생성방법과비교방식 
{
    public static void main(String[] args) 
    {
    	// 비교연산을 사용하면 안 되는 이유
    	// 문자열은 불변이기 때문에 효율성 증가를 위해 같은 값을 공유하도록 설계
    	// new 없이 문자열을 만들면 완벽하게 똑같은 인스턴스가 된다
    	String a = "hello";
    	String b = "hello";
    	String c = new String("hello"); // 신규 생성
    	String d = new String("hello"); // 신규 생성
    	
    	System.out.println(a == b);
    	System.out.println(b == c);
    	System.out.println(c == d);
    	System.out.println(d == a);
    	
       	System.out.println(a.equals(b));
    	System.out.println(b.equals(c));
    	System.out.println(c.equals(d));
    	System.out.println(d.equals(a));
    }
}