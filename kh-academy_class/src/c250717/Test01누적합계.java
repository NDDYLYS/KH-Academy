package c250717;;

public class Test01누적합계 
{
    public static void main(String[] args) 
    {
    	// 5를 10번 더하기
    	// 1을 10까지 더하기
    	
    	int total = 0;    	
    	for(int i = 0; i < 10; i++) 
    	{
    		total += 5;
    	}
    	
    	int total1 = 0;
    	
    	for(int i = 0; i < 10; i++) 
    	{
    		total1 += i + 1;
    	}
    	
    	System.out.println(total1);
    }
}