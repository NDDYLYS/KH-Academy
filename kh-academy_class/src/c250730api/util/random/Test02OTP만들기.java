package c250730api.util.random;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;
import java.util.UUID;


public class Test02OTP만들기 
{
    public static void main(String[] args) 
    {
    	// 6자리의 랜덤한 숫자를 생성하고 출력
    	// 시드를 조절해서 일정 시간동안 동일한 랜덤이 나오도록 구현
    	// 시드를 일정시간동안 같게 만드려면 시간값이 필요
    	Random r1 = new Random();
//    	//r1.setSeed(1L);
//    	r1.setSeed(System.currentTimeMillis() / 2000);
//    	int number = r1.nextInt(10) + 0;
//    	System.out.println("번호 : " + number);
//    	
//    	// 콤마 대신 띄어쓰기로 그룹핑 기호를 변경
//    	DecimalFormatSymbols symbols = new DecimalFormatSymbols();    	
//    	symbols.setGroupingSeparator(' ');
//    	System.out.println("번호 : " + fmt.format(number));
    	
    	DecimalFormat fmt = new DecimalFormat("000,000");
    	
    	String user1 = "ea088093-4c62-46aa-9a29-2edcd400c2e2";//UUID.randomUUID().toString(); // ea088093-4c62-46aa-9a29-2edcd400c2e2
    	String user2 = "8a15686e-09b5-4814-a91c-4ececdbcb0bc"; //UUID.randomUUID().toString(); // 8a15686e-09b5-4814-a91c-4ececdbcb0bc
    	System.out.println("user1 : " + user1);
    	System.out.println("user2 : " + user2);
    	
    	long time = System.currentTimeMillis() / 10000;
    	r1.setSeed(time + user1.hashCode());
    	int number = r1.nextInt(100000);
    	System.out.println("번호 : " + fmt.format(number));
    }
}
