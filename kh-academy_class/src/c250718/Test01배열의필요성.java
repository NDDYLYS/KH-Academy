package c250718;;

public class Test01배열의필요성 
{
    public static void main(String[] args) 
    {
    	// 배열
    	// 같은 종류의 데이터를 대량으로 보관하기 의한 저장소
    	
    	int a = 80, b = 70, c = 90, d = 85, e = 77;
    	
    	// 배열로 만들면 일괄 저장 및 처리가 가능하다
    	int[] scores = new int[] {80, 70, 90, 85, 77};
    	
    	// 자바는 주소가 안 나온다
    	
    	for (int i = 0; i < scores.length; i++) 
    	{
    		System.out.println(scores[i]);
    	}
    }
}