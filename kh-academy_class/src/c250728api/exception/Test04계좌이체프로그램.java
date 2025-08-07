package c250728api.exception;

import java.util.Scanner;

;

public class Test04계좌이체프로그램 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	int remain = 10000000;
    	String password = "1234";
    	
    	System.out.print("계좌 비밀번호를 입력해주세요 : ");
    	String input_pwd = sc.next(); // 내 계좌 비밀번호
    	System.out.print("이체할 계좌번호를 입력하세요(xxx-xx-xxxxxx) : ");
    	String input_accountNumber = sc.next(); // 이체 계좌번호
    	System.out.print("이체할 금액을 입력하세요(원) : ");
    	int input_transferAmount = sc.nextInt(); // 이체 금액
    	
    	sc.close();
    	
		try 
		{
			if (!input_pwd.equals(password))
				throw new Exception("비밀번호가 잘못 되었습니다.");
			
			String regex = "^[0-9]{3}-[0-9]{2}-[0-9]{6}$";
		 	boolean match = input_accountNumber.matches(regex);
	    	if (!match)
	    		throw new Exception("이체할 계좌번호가 잘못되었습니다.");
	    	if (input_transferAmount <= 0)
	    		throw new Exception("0원과 같거나 작운 금액은 이체할 수 없습니다.");
	    	if (1000000 < input_transferAmount)
	    		throw new Exception("이체하려는 금액이 1회 이체한도를 초월했습니다.");
		}
		catch(Exception e) 
		{
			System.err.println("[오류 발생] : " + e.getMessage());
			return;
		}
		
		remain -= input_transferAmount;
		System.out.println("이체 성공!" + " 남은 잔액 : " + String.format("%,d", remain) + "원");
    }
}