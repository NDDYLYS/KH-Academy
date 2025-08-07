package c250717;

import java.util.Scanner;

;

public class Test03현명한노인 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 	어느 고대 그리스에 현명하기로 소문난 노인이 있었습니다.
			그리스의 왕이 이 소문을 듣고 노인을 테스트하기 위해서 찾아가 다음과 같이 말했습니다.
			
			가지고 싶은게 있으면 딱 하나만 들어줄테니 말해봐라!
			
			노인이 왕의 말을 듣더니 다음과 같이 말했습니다.
			
			왕이시여, 저는 욕심이 없습니다. 
			다만 굳이 주신다고 하면 작은 소원하나 말해보겠습니다.
			30일동안 첫날은 금화 한닢을 주시고, 둘째날부터는 전날의 두배를 주십시오.
			
			왕은 겨우 금화 한닢을 달라고 하는 노인의 말에 감동받아서 소원을 들어주기로 했습니다.
			한달동안 노인이 받게되는 일자별 금화와 총 금화 개수를 각각 구하여 출력하세요!
    	 * */
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("금화를 며칠동안 주시겠습니까? : ");
    	int period = sc.nextInt();
    	sc.close();
    	
    	long totalCount = 0L;
    	long goldCoin = 1L;
    	for(int i = 0; i < period; i++) 
    	{
    		totalCount += goldCoin;
    		System.out.println((i + 1) +  "일에 받게 되는 금화의 개수는 " + String.format("%,d", goldCoin) + "개입니다.");
    		goldCoin *= 2;
    	}
    	
    	System.out.println(period + "일동안 받게 되는 금화의 개수는 " + String.format("%,d", totalCount) + "개입니다.");
    }
}