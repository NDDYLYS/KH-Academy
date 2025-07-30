package c250730api.time;

import java.time.Duration;
import java.time.LocalTime;

public class Test10LocalTime클래스 
{
    public static void main(String[] args) 
    {
    	LocalTime a = LocalTime.now();
    	LocalTime b = LocalTime.of(18, 0);
    	LocalTime c = LocalTime.parse("9:00");
    	
    	System.out.println("a = " + a);
    	System.out.println("b = " + b);
    	System.out.println("c = " + c);
    	
    	System.out.println("퇴근 시간 전인가요? = " + a.isBefore(b));
    	System.out.println("근무 시간인가요? = " + (a.isAfter(c) && a.isBefore(b)));
    	
    	Duration d = Duration.between(a, b);
    	System.out.println("d = " + d);
    	
    	System.out.println("d.toDaysPart = " + d.toDaysPart());
    	System.out.println("d.toHoursPart = " + d.toHoursPart());
    	System.out.println("d.toMinutesPart = " + d.toMinutesPart());
    	System.out.println("d.toSecondsPart = " + d.toSecondsPart());
    }
}