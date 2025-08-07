package c250717;

import java.util.Scanner;

public class Test05베스킨라빈스게임 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 
최초 1이라는 숫자로 시작.
사용자에게 1~3 사이의 숫자를 입력받아 해당하는 숫자만큼 최초의 숫자를 증가시킵니다.
최초의 숫자가 31이 넘어가기 직전에 마지막으로 입력한 사람이 패배하는 게임을 구현하세요.

현재 차례 : 1
1~3 사이의 숫자를 제시하세요 : (1)
현재 차례 : 2
1~3 사이의 숫자를 제시하세요 : (3)
현재 차례 : 5
1~3 사이의 숫자를 제시하세요 : (2)

...

현재 차례 : 31
1~3 사이의 숫자를 제시하세요 : (1)

당신은 31을 말했기 때문에 패배했습니다!


(+추가) 사용자가 1~3이 아닌 다른 숫자를 입력하면 재입력할 수 있는 로직을 추가해보세요
(+추가,풀이없음) 사용자끼리 하는 것이 아니라 사용자1명과 컴퓨터1명이 대결할 수 있도록 처리해보세요

---

출석인원 : 19명
    	 * */
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int count = 0;
    	int limit = 1;
    	System.out.println("현재 숫자 : " + limit);
    	
    	while (true) 
    	{
    		System.out.print("1~3 사이의 숫자를 제시하세요 : ");
    		int take = sc.nextInt();
    		System.out.println();
    		if (take < 1 || 3 < take) 
    		{
    			System.out.println("잘못된 숫자를 말했습니다. 다시 시도하세요.");
    			continue;
    		}
    		
    		limit += take;
    		System.out.println("현재 숫자 : " + limit);
    		System.out.println("숫자를 " + take + "만큼 더했습니다.");
    		
    		count ++;
    		
    		if (31 <= limit)
    		{
    			break;
    		}
    	}
    	
		System.out.println("당신은 31을 말했기 때문에 패배했습니다!");
		System.out.println("진행된 턴수 : " + count);
		
		sc.close();
    }
}