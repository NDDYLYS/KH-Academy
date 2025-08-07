package c250718;;

public class Test08데이터교체 
{
    public static void main(String[] args) 
    {
    	// 배열의 주요 계산과정 중 데이터 교체에 대해 알아본다
    	// 자바는 데이터 맞교환이 불능
    	
    	int[] numbers = new int[] {30, 50, 20, 10, 40};
    	
    	for(int i = 0; i < numbers.length; i++) 
    	{
    		
    	}
    	
    	int backup = numbers[0];
    	numbers[0] = numbers[3];
    	numbers[3] = backup;
    }
}