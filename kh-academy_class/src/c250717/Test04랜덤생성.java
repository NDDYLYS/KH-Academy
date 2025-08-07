package c250717;

import java.util.Random;

;

public class Test04랜덤생성 
{
    public static void main(String[] args) 
    {
    	// - 뭐가 나올지 예측이 불가능한 값
    	// - 기대하는 범위 내에서 나와야 함
    
    	Random r = new Random();
    	int a = r.nextInt();
    	
    	//System.out.println("a : " + a);
    	
    	// 주사위 던진 결과 한 개를 생성
    	int dice = r.nextInt(6) + 1;
    	//System.out.println("dice : " + dice);
    	
    	// 로또번호 1개
    	// 합격 시험점수 60점 이상 100점 이하
    	// 여섯자리 정수
    	// -45부터 +45 사이의 숫자 한개
    	
    	String lottos = "";
    	String tests = "";
    	String sixs = "";
    	String random_45s = "";
    	
    	for (int i = 0; i < 100; i++) 
    	{	    		
	    	int lotto = r.nextInt(45) + 1;
	    	//System.out.println("lotto : " + lotto);
	    	lottos += lotto + "/";
	    	
	    	int test = r.nextInt(41) + 60;
	    	//System.out.println("test : " + test);
	    	tests += test + "/";
	    	
	    	int six = r.nextInt(899999) + 100000;
	    	//System.out.println("six : " + six);
	    	sixs += six + "/";
	    	
	    	int random_45 = r.nextInt(91) - 45;
	    	//System.out.println("random_45 : " + random_45);
	    	random_45s += random_45 + "/";
    	}
    	
    	// close는 통로에만 가능
    	
    	System.out.println("lottos : " + lottos);
    	System.out.println("tests : " + tests);
    	System.out.println("sixs : " + sixs);
    	System.out.println("random_45s : " + random_45s);
    }
}