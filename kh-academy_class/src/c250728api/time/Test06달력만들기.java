package c250728api.time;

import java.util.Calendar;
import java.util.Scanner;

public class Test06달력만들기 
{
    public static void main(String[] args) 
    {
    	// 사용자에게 연도와 월에 해당하는 입력
    	// 무조건 6주를 출력
    	// 각 요일은 \t으로 간격 맞춤
    	// 모든 날짜를 출력해도 42알이 안 되면 다음달을 이어서 출력
    	// 만약 1일이 일요일이 아니라면 그 이전ㅇ 출력
    	// 한 줄에 7개의 요일이 출력
    	

    	Scanner sc = new Scanner(System.in);
    	System.out.print("연도를 입력해주세요. : ");
    	int year = sc.nextInt();
    	System.out.print("월을 입력해주세요. : ");
    	int month = sc.nextInt();
    	sc.close();
    	
    	Calendar c = Calendar.getInstance();
    	// c의 날짜를 달력 시작지점으로 이동
    	// 1일이 무슨 요일이냐에 따라 추가적으로 나와야 하는 이전 달의 날짜 수가 결정
    	c.set(year, month - 1, 1);
    	int week = c.get(Calendar.DAY_OF_WEEK);// 요일 구하기
    	c.add(Calendar.DATE, -week + 1); // 요일에 따라 날짜를 앞으로 이동시킨다
    	
    	int count = 0;
    	for(int i = 0; i < 42; i++) 
    	{
    		System.out.print(c.get(Calendar.DATE));
    		System.out.print("\t");
        	c.add(Calendar.DATE, 1);
        	
        	count ++;
        	if (count % 7 == 0) 
        	{
        		System.out.println();
        	}
    	}
    }
}