import java.util.Scanner;

public class Main 
{
        public static void main(String[] args) 
        {
        	Scanner sc = new Scanner(System.in);
        	int a = sc.nextInt();
        	
        	try 
        	{
        		if (a < 0)
        			throw new Exception("사람이 0명보다 작아선 안 됩니다.");
        	}
        	catch(Exception e) 
        	{
        	  	if (e.getMessage() == null) 
    	    	{
    	    		System.err.println("프로그램에서 오류가 발생했습니다.");
    	    	}
    	    	else 
    	    	{
    	    		System.err.println("[오류 발생] : " + e.getMessage());
    	    	}
        	}
        }
}