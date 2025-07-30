package c250728api.time;

import java.util.Scanner;
import java.util.Calendar;
import java.time.LocalDate;

public class Test07예약날짜선택 
{
    public static void main(String[] args) 
    {
    	try 
    	{
    		Scanner sc = new Scanner(System.in);
    		System.out.print("예약하실 날짜를 입력해주세요(yyyy-MM-dd) : ");
    		String input = sc.next();
    		sc.close();
    		
    		String temp1 = input.substring(0, 4);
    		//System.out.println(temp1);
    		int year = Integer.parseInt(temp1);
    		
    		String temp2 = input.substring(5, 7);
    		//System.out.println(temp2);
    		int month = Integer.parseInt(temp2);
    		
    		String temp3 = input.substring(8, 10);
    		//System.out.println(temp3);
    		int day = Integer.parseInt(temp3);
    		
    		Calendar c = Calendar.getInstance();
    		c.set(year, month - 1, day);
    		
    		
    		LocalDate now = LocalDate.now();
    		int currentYear = now.getYear();
    		int currentMonth = now.getMonthValue();
    		int currentDay = now.getDayOfMonth();
    		
    		boolean reservation = true;
    		
    		int temp_year = c.get(Calendar.YEAR);
    		int temp_month = c.get(Calendar.MONTH) + 1;
    		int temp_day = c.get(Calendar.DATE);
    		
    		//System.out.println(temp_year + " / " + temp_month + " / " + temp_day);
    		
    		if (temp_year == currentYear && temp_month == currentMonth && temp_day == currentDay)
    		{
    			reservation = false;
    			throw new Exception("당일 예약은 불가능");
    		}
    		
    		// Calendar reservation = Calendar.getInstance();
    		// reservation.before(year, month - 1, day);
    		// 권장하지 않음. 시간까지 전부 같아야 true가 가능
    		
    		if (temp_year < currentYear || temp_month < currentMonth || temp_day < currentDay)
    		{
    			reservation = false;
    			throw new Exception("지나간 날짜의 예약은 불가능");
    		}
    		
    		int weekend = c.get(Calendar.DAY_OF_WEEK);
    		if (weekend == 1 || weekend == 7)
    		{
    			reservation = false;
    			throw new Exception("주말은 예약이 불가능");
    		}
    		
    		System.out.println(temp_year + "년 " + temp_month + "월 " + temp_day + "일 날짜로 예약 성공!");
    	}
    	catch(Exception e) 
    	{
    		System.err.println("[오류 발생] : " + e.getMessage());
			return;
    	}
    	
    	
    }
}