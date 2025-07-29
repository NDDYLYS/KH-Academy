package c250728api.exception;

import java.util.Scanner;

public class Test01예외처리 
{
    public static void main(String[] args) 
    {
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
	    		throw new Exception();
	    	if (price < 0)
	    		throw new Exception();
	    	if (Integer.MAX_VALUE <  price)
	    		throw new Exception();
	    	
	    	double reward = (double)(price / peaple);
	 	    double reward2 = (double)(price % peaple);
	 	    System.out.println("1인당 금액" + reward);
	 	    System.out.println("자투리 금액: " + reward2 );
	    }
	    catch(Exception e) 
	    {
	    	System.out.println("입력 오류가 발생했습니다.");
	    	//e.printStackTrace();
	    }
	    sc.close();
	    // java.util.InputMismatchException
	  
    }
}