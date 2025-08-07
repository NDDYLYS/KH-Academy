package c250718;;

public class Test06상권분석 
{
    public static void main(String[] args) 
    {
    	// 음식점 창업 희망
    	// 6500, 13000, 15000. 10000, 9000, 7500, 10000
    	// 가장 비싼 식당의 밥값
    	// 식당의 밥값을 8500으로 하면 비싼 순서
    	
    	int[] res_prices = new int[] {6500, 50000, 13000, 15000, 
    									10000, 9000, 7500, 99999, 10000};
    	int myPrice = 8500;
    	int rank = 0;
    	
    	int position = 0;
    	int minimum = 0;
    	for(int i = 0; i < res_prices.length; i++) 
    	{
    		if (myPrice <= res_prices[i]) 
    		{
    			rank++;
    		}
    		
    		if (minimum < res_prices[i]) 
    		{
    			minimum = res_prices[i];
    			position = i + 1;
    		}
    		
    	}
    	
    	System.out.println("내가 " + myPrice + "원으로 창업한다면 난 " + rank + "번째로 비싼 식당이다.");
    	System.out.println("가장 비싼 식당의 가격 : " + minimum + "원이며, " + position + "번쨰 식당입니다.");
    }
}