package c250716;

import java.util.Scanner;

;

public class Test06타이머만들기 
{
    public static void main(String[] args) 
    {
    	// 사용자에게 분과 초를 입력 받아서 다음과 같이 타이머 메세지 출력
    	// 1분 20초 후 알람이 울립니다.
    	
    	Scanner sc = new Scanner(System.in);
		System.out.print("타이머의 분과 초를 입력해주세요(mmss) : ");
		int timer = sc.nextInt();
		sc.close();
		
		int minute = timer / 100;
		int second = timer % 100;
		int totalTimer = minute * 60 + second;
		
		for(int t = totalTimer; 0 < t; t--) 
		{
			int realMinute = t / 60;
			int realSecond = t % 60;
			
			System.out.println(realMinute + "분 " + realSecond + "초 후 알람이 울립니다.");
			
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
    	
		
		System.out.println("알람이 울리고 있습니다!");
    }
}