package c250729api.lang.etc;;

public class Test04Integer 
{
    public static void main(String[] args) 
    {
    	// int와 호환되는 하이브리드 클래스
    	
    	Integer a = new Integer(10); // 비추천 (메모리 낭비 심함)
    	Integer b = Integer.valueOf(10); // 추천 (작은 수는 신규 생성하지 않음)
    	Integer c = Integer.valueOf("10");
    	
    	// int가 좋은 상황
    	int v1 = 10;
    	int v2 = 20;
    	int v3 = v1 + v2;
    	System.out.println("v3 = " + v3);
    	
    	Integer v4 = Integer.valueOf(10);
    	Integer v5 = Integer.valueOf("20");
    	Integer v6 = Integer.sum(v4, v5);
    	System.out.println("v6 = " + v6);
    	
    	// Integer가 유리한 상황(복잡한 계산)
    	StringBuffer buffer = new StringBuffer();
    	for(int i = 100; i > 0; i /= 2) 
    	{
    		buffer.insert(0, i % 2);
    	}
    	System.out.println(buffer.toString());
    	
    	System.out.println(Integer.toBinaryString(100));
    	
    	// Integer와 int는 정말 특수한 상황이 아니면 그냥 섞어 써도 된다
    	Integer x1 = 10; // 자동 포장 auto-boxing
    	
    	// int와 Integer의 결정적인 차이는 null 표현 가능 여부이다
    	// int y1 = null;
    	// Integer y2 = null;
    	
    	String number = "123456";
    	int convert = Integer.parseInt(number);
    	System.out.println("convert : " + convert);
    	
    	/*
    	 * 				Wrapper class
    	 * 원시형			참조형
    	 * boolean		Boolean
    	 * byte			Byte
    	 * short		Short
    	 * char			Character
    	 * int			Integer
    	 * long			Long
    	 * float		Float
    	 * double		Double
    	 * */
    }
}