package c250717;

import java.util.Scanner;

;

public class Test04숫자모래성게임 
{
    public static void main(String[] args) 
    {
    /*
Test04숫자모래성게임
최초에 100이라는 값으로 시작.
사용자에게 1~9이내의 숫자를 입력받아 기존의 숫자에서 차감시킴.
0이 되기 직전에 입력한 사람이 패배하는 게임을 구현하세요.

현재 남은 숫자 : 100
가져갈 숫자 입력(1~9 사이) : (5)

현재 남은 숫자 : 95
가져갈 숫자 입력(1~9 사이) : (8)

현재 남은 숫자 : 87

...(중간생략)...

현재 남은 숫자 : 1
가져갈 숫자 입력(1~9 사이) : (1)

당신은 패배했습니다.
진행된 턴 수 : 8
     */	
    	Scanner sc = new Scanner(System.in);
    	
    	int count = 0;
    	int limit = 100;
    	System.out.println("현재 남은 숫자 : " + limit);
    	
    	while (true) 
    	{
    		System.out.print("가져갈 숫자를 입력하세요(1~9 사이) : ");
    		int take = sc.nextInt();
    		System.out.println();
    		
    		limit -= take;
    		System.out.println("현재 남은 숫자 : " + limit);
    		System.out.println("숫자를 " + take + "만큼 가져갔습니다.");
    		
    		count ++;
    		
    		if (limit <= 0)
    		{
    			break;
    		}
    	}
    	
		System.out.println("더 이상 모래가 남아있지 않습니다. 당신이 패배했습니다.");
		System.out.println("진행된 턴수 : " + count);
		
		sc.close();
    }
}