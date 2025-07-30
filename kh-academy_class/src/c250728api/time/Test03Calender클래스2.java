package c250728api.time;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test03Calender클래스2 
{
    public static void main(String[] args) 
    {
    	Calendar a = new GregorianCalendar();
    	Calendar b = Calendar.getInstance();
    	
    	System.out.println("a = " + a);
    	System.out.println("b = " + b);
    	
    	// b의 시간정보변경
    	// b의 연도를 변경하는 메소드는 setYear()여야 한다
    	// 하지만 30년 전에는 메소드를 최소한으로 만들어서 처리하는 것이 유행
    	// set(항목, 값)과 같은 형태로 모든 항목을 변경할 수 있도록 구현
    	b.set(Calendar.YEAR, 2000);
    	b.set(Calendar.MONTH, 0);
    	b.set(Calendar.DATE, 1);
    	
    	// 여러가지 유용한 메소드가 존재
    	int max = b.getActualMaximum(Calendar.DATE);
    	System.out.println("max = " + max);
    	
    	// 인스턴스의 시간 정보를 추출하여 출력
    	// 각 요소별 추출
    	// b에 있는 연도를 추출하는 메소드의 예상되는 이름은?
    	// 하지만 30년 전에는 메소드를 최소한으로 만들어서 처리하는 것이 유행
    	// get()과 같은 형태로 데이터를 얻도록  구현
    	// 1900년을 기준으로 하지 않는다
    	// 시간 변경이 가능하다
    	// Date와 호환이 됨
    	// 월은 0부터 시작한다
    	int year = b.get(Calendar.YEAR);
      	System.out.println("year = " + year);
    	int month = b.get(Calendar.MONTH) + 1;// 월은 0부터 시작하므로 보정 필요
      	System.out.println("month = " + month);
      	int day = b.get(Calendar.DATE);
     	System.out.println("day = " + day);
     	
     	int hour = b.get(Calendar.HOUR);
     	System.out.println("hour = " + hour);
     	int minute = b.get(Calendar.MINUTE);
     	System.out.println("minute = " + minute);
     	int second = b.get(Calendar.SECOND);
     	System.out.println("second = " + second);
     	int millisecond = b.get(Calendar.MILLISECOND);
     	System.out.println("millisecond = " + millisecond);
     	
     	int am_pm = b.get(Calendar.AM_PM); // 0 오전, 1 오후
     	System.out.println("am_pm = " + am_pm);     	
     	int week = b.get(Calendar.DAY_OF_WEEK);
     	System.out.println("week = " + week);
      	
    	//Date로 바꿔서 추출
    	Date d = b.getTime();
    	SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 H시 m분 s초");
    	System.out.println("시간 = " + fmt.format(d));
    }
}