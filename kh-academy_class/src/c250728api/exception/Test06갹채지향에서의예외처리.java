package c250728api.exception;;

public class Test06갹채지향에서의예외처리 
{
    public static void main(String[] args) throws Exception
    {
    	try 
    	{    		
    		int result = Calculator.div(10, 0);
    		System.out.print("result = " + result);
    	}
    	catch(Exception e)
    	{
    		// Stack Trace
    		e.printStackTrace();
    	}
    }
}
