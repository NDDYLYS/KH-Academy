package c250718;;

public class Test07데이터분석 
{
    public static void main(String[] args) 
    {
    	/*다음 키 정보를 토대로 최대값, 최소값, 평균을 계산하여 출력

		float[] studentList = new float[] {
		    168.3f, 171.7f, 175.2f, 178.0f, 169.5f,
		    174.4f, 176.9f, 172.1f, 170.6f, 179.3f
		};
    	 * */
    	
    	float[] talls = new float[] { 5f, 77777f, 168.3f, 171.7f, 175.2f, 178.0f, 169.5f,
    		    174.4f, 176.9f, 172.1f, 170.6f, 179.3f, 999.9f, 50.f};
    	
    	float maximum = 0f;
    	float minimum = 10000f;
    	
    	float sum = 0f;
    	for(int i = 0; i < talls.length; i++) 
    	{
    		sum += talls[i];
    		
    		if (maximum < talls[i]) 
    		{
    			maximum = talls[i];
    		}
    		
    		if (talls[i] < minimum) 
    		{
    			minimum = talls[i];
    		}
    	}
    	
    	System.out.println("평균 : " + ((float)sum / talls.length));
    	System.out.println("최대값 : " + maximum);
    	System.out.println("최소값 : " + minimum);
    }
}