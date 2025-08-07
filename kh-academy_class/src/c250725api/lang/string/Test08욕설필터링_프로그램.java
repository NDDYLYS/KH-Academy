package c250725api.lang.string;

import java.util.Scanner;

;

public class Test08욕설필터링_프로그램 
{
    public static void main(String[] args) 
    {
    	// 1. '운영자'는 '###'로 교체
    	// 2. 욕설은 마스킹 처리
    	// - 마스킹 처리는 *로 바꾸는 것
    	
    	// 십장생, 수박씨, 조카, 주옥, 개나리, 신발끈, 시베리아, 십자수, 시방, 빙수
    	
    	String gm = "운영자";
    
    	Scanner sc = new Scanner(System.in);
    	String[] maskings = new String[] {"십장생", "수박씨", "조카", "주옥", "개나리",
				"신발끈", "시베리아", "십자수", "시방", "빙수"};
    	
    	while(true) 
    	{
    		String line = sc.next();
    		if (line.contains(gm)) 
    		{
    			String filter = "#";
    			filter.repeat(gm.length());
    			
    			line = line.replace(gm, filter);
    		}
    		
    		for(int i = 0; i < maskings.length; i++) 
    		{
    			if (line.contains(maskings[i])) 
        		{
        			String filter = "*";
        			filter.repeat(maskings[i].length());
        			
        			line = line.replace(maskings[i], filter);
        		}
    		}
    		
    		System.out.println(line);
    	}
    	
    }
}