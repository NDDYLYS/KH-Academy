package c250730api.util.scanner;

import java.util.Scanner;

;

public class Test01Scanner클래스 
{
    public static void main(String[] args) 
    {
    	// 문자열 패턴 분석 추출기
    	// 제공되는 문자열에 원하는 데이터 부분만 추출할 수 있음
    	// next() 명령들은 공백(스페이스, 탭, 개행)을 기준으로 데이터를 읽는다
    	// nextLine은 \n, 개행만 인식한다. 1줄 전체를 인식한다.
    	
    	String example = "Golden1 Golden2 Golden3 Golden4 Golden5";
    	Scanner sc = new Scanner(example);
    	
    	while(sc.hasNextLine()) 
    	{
    		String word = sc.nextLine();
    		System.out.println("word : " + word);
    	}
    	
    	sc.close();
    }
}