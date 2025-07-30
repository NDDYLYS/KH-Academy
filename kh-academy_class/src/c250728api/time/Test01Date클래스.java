package c250728api.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01Date클래스 
{
    public static void main(String[] args) 
    {
    	/*
    	 * java.util에 있는 Date 클래스의 API를 참고해서 다음 정보를 가지는 날짜 인스턴스를 생성
    	 * 1946 2 14
    	 * 2025 12 23
    	 * */
    	
    	// Date는 자바 최초 버젼으로 만들어진 시간 관리 클래스
    	Date a = new Date(46, 1, 14);
    	System.out.println(a);
    	
    	Date b = new Date(125, 11, 23);
    	System.out.println(b);
    	
    	Date c = new Date(System.currentTimeMillis());
    	//Date d = new Date();
    	
    	System.out.println(c);
    	//System.out.println(d);
    }
}