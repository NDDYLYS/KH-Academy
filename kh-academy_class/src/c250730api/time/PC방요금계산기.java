package c250730api.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

;

public class PC방요금계산기 
{
    public static void main(String[] args) 
    {
    	// 시작시간과 종료시간을 hh:mm으로 입력
    	// 요금은 시간당 1000원
    	
    	try 
    	{
    		Scanner sc = new Scanner(System.in);
    		System.out.print("시작시간을 입력해주세요(hh:mm) : ");
    		
    		int in_hour = 0;
    		int in_minute = 0;
    		int out_hour = 0;
    		int out_minute = 0;    		
    		
    		if (sc.hasNextLine()) 
    		{
    			String temp1 = sc.nextLine();
    			
    			String hour1 = temp1.substring(0, 2);
    			in_hour = Integer.parseInt(hour1);
    			
    			String minute1 = temp1.substring(3, 5);
    			in_minute = Integer.parseInt(minute1);
    		}
    		else
    			throw new Exception("입력값이 잘못 되었습니다.");
    		
    		System.out.print("종료시간을 입력해주세요(hh:mm) : ");
    		
    		if (sc.hasNextLine())    		
    		{
    			String temp2 = sc.nextLine();
    			
    			String hour2 = temp2.substring(0, 2);
    			out_hour = Integer.parseInt(hour2);
    			
    			String minute2 = temp2.substring(3, 5);
    			out_minute = Integer.parseInt(minute2);
    		}
    		else
    			throw new Exception("입력값이 잘못 되었습니다.");
    		
    		LocalTime in = LocalTime.of(in_hour, in_minute);
    		LocalTime out = LocalTime.of(out_hour, out_minute);
    		
        	Duration gap = Duration.between(in, out);
        	long minutesofuse = gap.toHours() + gap.toMinutesPart();
        	int price60 = 1000;
        	
        	int totalPrice = 0;
        	totalPrice += gap.toHoursPart() * price60;
        	totalPrice += gap.toMinutesPart() * (price60 / 60);
        	
        	System.out.println("시작시간 = " + in);
        	System.out.println("종료시간 = " + out);
        	System.out.println("이용시간 = " + gap.toHoursPart() + "시간 " + gap.toMinutesPart() + "분");
        	System.out.println("총 금액 = " + totalPrice + "원");
    		
        	// DecimalFormat df = new DecimalFormat(""#,##0) ;
    		
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    }
}