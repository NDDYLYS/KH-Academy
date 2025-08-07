package c250730api.time;

import java.time.*;
import java.util.Scanner;

public class text 
{
    public static void main(String[] args) 
    {
    	//LocalDate today= LocalDate.now();
    	//LocalDate reservation = LocalDate.parse(date);
    	//if (today.equals(reservation)) 
    	//{
    	//	thorw new Exception("예약 불가");
    	//}
    	
    	// isEqual()
    	// reservation.isBefore(today) == today.isAfter(reservation)
    	Scanner sc = new Scanner(System.in);
    	int year = sc.nextInt();
    	
    	 boolean isLeap = Year.isLeap(year);
    	 
    	 System.out.println(year + "년은 윤년이" + isLeap);
    }
}