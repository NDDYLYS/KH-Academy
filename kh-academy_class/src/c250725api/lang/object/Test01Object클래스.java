package c250725api.lang.object;;

public class Test01Object클래스 
{
    public static void main(String[] args) 
    {
    	// 남이 만든 클래스의 구조를 예상해가며 이용
    	
    	Object a = new Object();
    	Object b = new Object();
   
    	// 일련번호 : 동일 여부를 판정
    	System.out.println(a.hashCode());
    	System.out.println(b.hashCode());
    	
    	// 인스턴스의 요약정보를 반환(클래스명@일련번호)
    	System.out.println(a.toString());
    	System.out.println(b.toString());
    	
    	
    }
}