package c250714;

public class pc_price2 
{
	public static void main(String[] args) 
	{
		// 입장 10시 30분
		// 퇴장 16시 15분
		// 시간당 1000원		

		// 시간당 요금
		int priceH = 1000;
		//분당 요금
		double priceM = priceH / 60.0;

		// 들어온 시간
		int comein_time = (10 * 60) + 30;
		// 나간 시간
		int goout_time = (12 * 60) + 30;
		// 머무른 시간
		int stay_time = goout_time - comein_time;
		
		// 총 요금
		double totalPrice = stay_time * priceM;
		
		int totalPrice2 = (int)(totalPrice / 100) * 100;
		
		System.out.println("피시방에서 머무른 시간은 " + stay_time +"분이며, 내야 하는 금액은 " + totalPrice2 + "원입니다.");
	}
}
