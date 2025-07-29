package c250728api.lang.string3;;

public class Test01문자열합성 
{
    public static void main(String[] args) 
    {
    	// 문자열은 불변. new 없으면 똑같은 인스턴스로 생성
    	// 장점 : 안정성, 속도, 메모리 효율
    	// 단점 : 변경되면 새로 만들어야 함
    	
    	// 합성 속도 측정 : 시간복잡도 > 최선(Big-Omega), 평균(Big-Theta), 최악(Big-Oh)

    	// 빌더는 빠르지만 불안정하다.
    	
    	// 문자열 패밀리 " Character Sequence
    	StringBuilder result = new StringBuilder("*");
    	
    	long begin = System.currentTimeMillis();
    	for(int i = 0; i < 10000000; i++) 
    	{
    		result.append("*");    		
    	}
    	long end = System.currentTimeMillis();
    	System.out.println(end - begin);
    	
    }
}