package c250718;;

public class Test02여러가지배열생성 
{
    public static void main(String[] args) 
    {
    /*	15.2, 20.6, 35.7, 22.1, 30.6
		자바, 안드로이드, 스프링, JSP
		100L, 200L, 300L
     * */
    	
    	float[] floatArray = new float[] {15.2f, 20.6f, 35.7f, 22.1f, 30.6f};
    	String[] stringArray = new String[] {"자바", "안드로이드", "스프링", "JSP"};
    	long[] longArray = new long[] {100L, 200L, 300L};
    	
    	for(int i = 0; i < floatArray.length; i++) 
    	{
    		System.out.println(floatArray[i]);
    	}
    	
    	for(int i = 0; i < stringArray.length; i++) 
    	{
    		System.out.println(stringArray[i]);
    	}
    	
    	for(int i = 0; i < longArray.length; i++) 
    	{
    		System.out.println(longArray [i]);
    	}
    }
}