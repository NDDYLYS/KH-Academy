package c250730api.util.random;

import java.util.Random;

;

public class Test01Random클래스 
{
    public static void main(String[] args) 
    {
    	// 랜덤 데이터를 생성하는 클래스
    	// 시드를 통제한다면 랜덤을 통제할 수 있다
    	Random r1 = new Random();
    	Random r2 = new Random(1L);
    	Random r3 = new Random(50L);
    	
    	int lotto1 = r1.nextInt(45) + 1;
    	int lotto2 = r2.nextInt(45) + 1;
    	int lotto3 = r3.nextInt(45) + 1;
    	
    	System.out.println("lotto1 = " + lotto1);
    	System.out.println("lotto2 = " + lotto2);
    	System.out.println("lotto3 = " + lotto3);
    	
    	System.out.println("논리1 : " + r1.nextBoolean());
       	System.out.println("실수1 : " + r1.nextFloat());
       	System.out.println("실수1 : " + r1.nextDouble());
       	System.out.println("가우스분포 : " + r1.nextGaussian());
    }
}