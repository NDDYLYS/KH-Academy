package c250729api.lang.etc;;

public class Test02SystemMethod 
{
    public static void main(String[] args) 
    {
    	// 프로그램 외부 환경 정보를 읽을 수 있는 도구
    	
    	/*
    	 * 시간 측정
    	 * System.currentTimeMilis();
    	 * 외부 환경 정보를 읽어와서 사용
    	 * System.getProperty("java.specfication.version");
    	 * System.getProperty("os.name");
    	 * System.getProperty("user.contry");
    	 * System.getProperty("user.language");
    	 * System.getProperty("user.home");
    	 * System.getProperty("user.dir");
   	 * */
    	
    	String name = System.getProperty("os.name");
    	if (name.toLowerCase().startsWith("windows")) 
    	{
    		// 윈도우 사용    		
    	}
    	else if (name.toLowerCase().startsWith("mac")) 
    	{
    		// 맥 사용    		
    	}
    	
    	// 각종 시스템 통로가 존재(출력 out, 입력 in, 에러 err)
    	
    	System.exit(0); // 시스템 종료 / 프로그램을 종료시킨다
    	// 0 정상 종료 / 다른 수 : 문제가 있음
    	// return; // main 메소드를 종료시킨다
    }
}