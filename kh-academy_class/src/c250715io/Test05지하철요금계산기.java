package c250715io;

import java.util.Scanner;
import java.time.LocalDate;

public class Test05지하철요금계산기 
{
	public static void main(String[] args) 
	{
		/*
	 	사용자에게 출생년도 4자리를 숫자로 입력받습니다.
		이를 토대로 지하철 요금을 계산하여 출력해주세요.
		
		성인 (20세 ~ 64세) : 1550원
		청소년 (14세 ~ 19세) : 900원
		어린이 (8세 ~ 13세) : 550원
		어르신(65세~) 및 영유아(~7세) : 무료
		
		(+추가) 카드 보증금 500원을 더해서 보여줄 수 있도록 업그레이드 하세요
		 */
		
		Scanner sc = new Scanner(System.in);
		LocalDate now = LocalDate.now();
		
		System.out.print("출생 년도를 입력하세요. : ");
		int birth = sc.nextInt();
		sc.close();
		int year = now.getYear();
		
		int koreanAge = year - birth + 1;
		
		String subwayCategory = "";
		String subwayPrice;
		
		if (20 <= koreanAge && koreanAge <= 64) 
		{
			subwayCategory = "성인(20~64)";
			subwayPrice = "1550원";
		}
		else if (14 <= koreanAge && koreanAge <= 19) 
		{
			subwayCategory = "청소년(14~19)";
			subwayPrice = "900원";
		}
		else if (8 <= koreanAge && koreanAge <= 13) 
		{
			subwayCategory = "어린이(8~13)";
			subwayPrice = "550원";
		}
		else
		{
			subwayCategory = "어르신 및 영유아(65~ || ~7)";
			subwayPrice = "무료";
		}
		
		System.out.println(birth + "년에 출생한 사람은 " + subwayCategory + "이며 지하철 요금은 " + subwayPrice + "입니다.");
	}
}