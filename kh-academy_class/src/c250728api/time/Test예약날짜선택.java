package c250728api.time;

import java.util.Scanner;
import java.util.Calendar;
import java.time.LocalDate;

public class Test예약날짜선택 
{
    public static void main(String[] args) 
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
    	int temp_month = c.get(Calendar.MONTH);
    	int temp_day = c.get(Calendar.DATE);
    	
    	if (temp_year == currentYear && temp_month == currentMonth && temp_day == currentDay)
    	{
    		reservation = false;
    		System.out.println("당일 예약은 불가능");
    		return;
    	}
    	
    	if (temp_year <= currentYear && temp_month <= currentMonth && temp_day <= currentDay)
    	{
    		reservation = false;
    		System.out.println("지나간 날짜의 예약은 불가능");
    		return;
    	}
    	
    	int weekend = c.get(Calendar.WEEK_OF_MONTH);
    	if (weekend == 1 || weekend == 7)
    	{
    		reservation = false;
    		System.out.println("주말은 예약이 불가능");
    		return;
    	}
    	
    	System.out.println(year + "년 " + month + "월 " + day + "일 날짜로 예약 성공!");
    }
}