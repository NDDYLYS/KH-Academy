package c250715io;

import java.time.LocalDate;
import java.util.Scanner;

public class Test06여행사프로모션 
{
	public static void main(String[] args) 
	{
		// 장소 무관 1인당 하루에 10만원
		// 계절마다 다른 할인
		
		// 봄345 25%할인
		// 여름678 5%할인
		// 가을91011 10%할인
		// 겨울1212 30%할인

		// 사용자에게 인원수와 기간, 여행갈 달을 입력받아 예상경비를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("여행을 몇 명이서 가실 건가요? : ");
		int nop = sc.nextInt();
		System.out.print("여행을 얼마나 가실 건가요? : ");
		int period = sc.nextInt();
		System.out.print("여행을 언제부터 가실 건가요? : ");
		int season = sc.nextInt();
		
		int springDiscount = 75000;
		int summerDiscount = 95000;
		int fallDiscount = 90000;
		int winterDiscount = 70000;
		
		
		
		
		sc.close();
		LocalDate now = LocalDate.now();
	}
}