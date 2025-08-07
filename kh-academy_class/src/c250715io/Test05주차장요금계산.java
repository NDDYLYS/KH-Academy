package c250715io;

import java.util.Scanner;

public class Test05주차장요금계산 
{
	public static void main(String[] args) 
	{
		/*
		 * 	KH주차장의 이용요금은 다음과 같습니다.
			10분당 500원
			0~9분까지는 무료
			10~19분까지는 500원
			이후도 10분간격으로 동일한 요금 설정
			
			사용자가 입차시각과 출차시각을 입력하면 총 이용시간과 이용요금이 출력되도록 구현
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입차 시각을 입력하세요. (hhmm)");
		int in_time = sc.nextInt();
		int in_hour = in_time / 100;
		int in_minute = in_time % 100;
		
		System.out.println("출차 시각을 입력하세요. (hhmm)");
		int out_time = sc.nextInt();
		int out_hour = out_time / 100;
		int out_minute = out_time % 100;
		
		//1230 -> hour : /100 || minute : %100
		
		int price10 = 500;
		
		int stay_time = out_time - in_time;
		int time = stay_time / 10;
		
		int totalPrice = (stay_time / 10) * price10;
		
		System.out.println(in_hour + "시 " + in_minute + "분에 들어와서 " + out_hour + "시 " + out_minute + "분에 나간 차량의 주차 요금은 " + totalPrice + "원입니다.");
		
		sc.close();
	}
}