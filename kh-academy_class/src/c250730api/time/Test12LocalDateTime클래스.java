package c250730api.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Test12LocalDateTime클래스 
{
    public static void main(String[] args) 
    {
    	// 시간과 날짜 모두를 가지는 클래스
    	// 명령 체계는 앞에서 본 클래스와 동일
    	LocalDateTime t1 = LocalDateTime.now();
//    	LocalDateTime t2 = LocalDateTime.of(2025,  12, 31, 18, 0, 0);
//    	LocalDateTime t3 = LocalDateTime.parse("2025-12-23T23:00");
//    	
    	System.out.println("t1 : " + t1);
//    	System.out.println("t2 : " + t2);
//    	System.out.println("t3 : " + t3);
//    	
//    	Period p = Period.between(t1.toLocalDate(), t2.toLocalDate());
//    	System.out.println("p : " + p.getMonths() + "/"+ p.getDays());
//    	Duration d = Duration.between(t2, t3);
//    	System.out.println("d : " + d.toDays());
    	
    	// t1과 같은 해 1월 1일로 날짜를 변경하여 새로운 인스턴스를 생성하세요.
    	LocalDateTime t4 = LocalDateTime.of(t1.getYear(), 1, 1, t1.getHour(), t1.getMinute(), t1.getSecond(), t1.getNano());
     	System.out.println("t4 : " + t4);
     	
     	LocalDateTime t5 = t1.withMonth(1).withDayOfMonth(1);
     	System.out.println("t5 : " + t5);
    }
}