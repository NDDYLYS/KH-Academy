package c250730api.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

;

public class Test08LocalData클래스 
{
    public static void main(String[] args) 
    {
    	// 월을 1~12가 아닌 0~11로 관리한다
    	// Calendar의 set은 너무 옛날 방식이라 용도 파악이 힘들다
    	// 윤년 파악을 할 수는 있지만 너무 복잡하다
    	// (★)날짜가 가변이다
    	// 시간 변경은 비교적 쉬우나 차이를 구하기 어렵다
    	// (★)날짜랑 시간이 반드시 같이 보관된다
    	// Date는 똑같은 이름이 또 있다
    	
    	// -> 등장하는 클래스들
    	// LocalDate 연월일만 저장
    	// LocalTime 시분초를 저장
    	// LocalDateTime 날짜와 시간을 저장
    	// ZoneDateTime 시간대를 설정
    	// Period 기간 계산용
    	// Duration 시간 계산용
    	// DateTimeFormatter 날짜 입출력 형식 설정용
    	
    	LocalDate a = LocalDate.now();
    	LocalDate b = LocalDate.of(2025, 12, 23);
    	
    	System.out.println("a : " + a);
    	System.out.println("b : " + b);
    	
    	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	System.out.println("a.format(fmt) : " + a.format(fmt));
    	System.out.println("b.format(fmt) : " + b.format(fmt));
    	
    	System.out.println("윤년검사 : " + a.isLeapYear());

    	// 불변
    	LocalDate future = a.plusDays(100L);
    	System.out.println("a : " + a);
    	System.out.println("future : " + future);
    	
    	// 정보 추출
     	System.out.println("a.Year : " + a.getYear());
     	System.out.println("a.Month : " + a.getMonthValue());
     	System.out.println("a.Month : " + a.getMonth().getDisplayName(TextStyle.FULL, Locale.KOREA));
     	System.out.println("a.Day : " + a.getDayOfMonth());
     	
     	// a와 b 사이의 기간 구하기
     	Period p = Period.between(a, b);
     	System.out.println("p : " + p);
     	System.out.println("p.getYears : " + p.getYears());
     	System.out.println("p.getMonths : " + p.getMonths());
     	System.out.println("p.getDays : " + p.getDays());
     	
     	// 기간을 생성해서 날짜 더하기
     	Period year3 = Period.of(3, 2, 0);
     	LocalDate c = b.plus(year3);
     	System.out.println("c : " + c);
    }
}