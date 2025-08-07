package c250715io;

import java.time.LocalDate;
import java.util.Scanner;

public class Test07주차요금계산기 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		LocalDate now = LocalDate.now();
		
		/*
		 * 입차 후 30분 내에 출차하면 무료
		 * 31분부터는 10분당 500원 부과
		 * 한 번 주차시 최대 요금은 2만원
		 * */
		
		System.out.print("입차 시간을 적어주세요(hhmm) : ");
		int comein = sc.nextInt();
		int comein_hour = comein / 100;
		int comein_minute = comein % 100;
		int comein_time = comein_hour * 60 + comein_minute;
		
		System.out.print("출차 시간을 적어주세요(hhmm) : ");
		int goout = sc.nextInt();
		int goout_hour = goout / 100;
		int goout_minute = goout % 100;
		int goout_time = goout_hour * 60 + goout_minute;
		
		int parking_time = goout_time - comein_time;
		
		sc.close();
		
		// 10분 주차당 500원
		int parking_10_Price = 500;
		// 주차 금액
		int totalPrice = 0;
		
		if (parking_time <= 30) 
		{
			// 30분 무료
			totalPrice = 0;
		}
		else 
		{
			totalPrice = (parking_time / 10) * parking_10_Price;
		}
		
		
		if (20000 < totalPrice) 
		{
			// 2만원이 최대 금액
			totalPrice = 20000;
		}
			
		System.out.println("입차 시간 : " + comein + ", 출차 시간 : " + goout + ", 주차 시간 : " + parking_time);
		System.out.println("주차 금액 : " + totalPrice + "원");
	}
}