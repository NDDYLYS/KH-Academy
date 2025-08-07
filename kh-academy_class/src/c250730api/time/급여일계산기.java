package c250730api.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class 급여일계산기 
{
    public static void main(String[] args) 
    {
    	// 현재 시점을 기준으로 하여 급여일을 입력받아 1년치 급여일을 출력하세요
    	// 단 급여일이 주말이라면 가장 가까운 이전 날짜의 평일에 지급하는 걸로 조정
    	// 급여일 : 5
    	
    	
    	try 
    	{    		
    		LocalDate[] holidays = new LocalDate[]{
   		  	LocalDate.of(2025, 1, 1), LocalDate.of(2025, 3, 1),
       		LocalDate.of(2025, 3, 3), LocalDate.of(2025, 5, 5), 
       		LocalDate.of(2025, 5, 6), LocalDate.of(2025, 6, 6), LocalDate.of(2025, 8, 15),
       		LocalDate.of(2025, 10, 3), LocalDate.of(2025, 10, 9), LocalDate.of(2025, 12, 25)};
    		
    		Scanner sc = new Scanner(System.in);
    		System.out.print("급여일을 입력해주세요 : ");
    		int payday = 0;
    		
    		if (sc.hasNextInt())
    			payday = sc.nextInt();
    		else
    			throw new Exception("입력값이 잘못 되었습니다.");
    		
    		for(int month = 1; month < 13; month++) 
    		{
    			LocalDate pay = LocalDate.of(LocalDate.now().getYear(), month, payday);
    			
    			DayOfWeek week = pay.getDayOfWeek();
    			if (week == DayOfWeek.SATURDAY)
    				pay = pay.minusDays(1);
    			else if (week == DayOfWeek.SUNDAY)
    				pay = pay.minusDays(2);
    			
    			for(int h = 0; h < holidays.length; h++) 
    			{
    				if (pay.equals(holidays)) 
    				{
    					pay = pay.minusDays(1);
    					break;
    				}
    			}    			
    			
    			System.out.println("급여일 : " + pay);
    		}
    		
    		
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    }
}