package c250725api.lang.string;;

public class Test02문자열생성 
{
    public static void main(String[] args) 
    {
    	String a = "hello";
    	String b = new String("hello");
    	
    	byte[] bytes = new byte[] {104, 101, 108, 108, 111};
    	String d = new String(bytes);
    	
    	System.out.println("a = " + a.toString());
    	System.out.println("b = " + b.toString());
    	System.out.println("d = " + d.toString());
    	
    	System.out.println("a = " + a.hashCode());
    	System.out.println("b = " + b.hashCode());
    	System.out.println("d = " + d.hashCode());
    
    	System.out.println(a == b);
    	System.out.println(a.equals(b));
    	
    	String e = "Hello";
    	System.out.println(a.equals(e));
    	System.out.println(a.equalsIgnoreCase(e)); // 대소비교 무시
    }
}