package c250728api.exception;

import java.util.Scanner;

public class Test01예외처리3 
{
    public static void main(String[] args) 
    {
    	// 통합된 예외 상황에서의 메세지 출력
    	// 에러(프로그램이 실행되지 않는 상황)와 예외는 구분하자
    	
    	// 1/n 계산
	    Scanner sc = new Scanner(System.in);
	    
	    // 사람 수가 0명일 때
	    // try에는 플린 A를 작성하고 catch에는 플랜 B를 작성
	    // Throwable 가장 많은 종류를 처리하지만 에러까지 같이 처리됨
	    // Exception 실질적인 예외의 아버지이다
	    // RuntimeException 실행 중 예외를 의미
	    
	    try 
	    {
	    	int peaple = sc.nextInt();
	    	int price = sc.nextInt();
	    	
	    	if (peaple < 0)
	    		throw new Exception("사람이 0명보다 작아선 안 됩니다.");
	    	if (price < 0)
	    		throw new Exception("금액은 0원 이상이어야 합니다.");
	    	if (Integer.MAX_VALUE <  price)
	    		throw new Exception("가격이 인트 최대값을 넘어셨습니다.");
	    	
	    	double reward = (double)(price / peaple);
	 	    double reward2 = (double)(price % peaple);
	 	    System.out.println("1인당 금액" + reward);
	 	    System.out.println("자투리 금액: " + reward2 );
	    }
	    catch(Exception e) 
	    {
	    	// e.getMassage()를 이용하면 설정된 예외 메세지를 확인할 수 있다.
	    	// 없으면 null
	    	
	    	if (e.getMessage() == null) 
	    	{
	    		System.err .println("프로그램에서 오류가 발생했습니다.");
	    	}
	    	else 
	    	{
	    		System.err.println("[오류 발생] : " + e.getMessage());
	    	}
	    }
	    finally 
	    {
	    	sc.close(); // 반드시 닫히게 된다.	    	
	    }
	    
	    // java.util.InputMismatchException
	  
    }
}