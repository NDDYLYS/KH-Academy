package c250728api.time;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test04랜덤날짜추첨기 
{
    public static void main(String[] args) 
    {
    	// 2026년 중에서 무작위로 하루를 뽑아서 다음 형식으로 출력
    	// -> 2026년 3월 25일 수요일
    	// 주말 중에서 하루를 출력
    	
    	Calendar b = Calendar.getInstance();
    	Random r = new Random();

    	while(true) 
    	{
    		b.set(Calendar.YEAR, 2026);
    		b.set(Calendar.MONTH, 0);
    		b.set(Calendar.DATE, r.nextInt(365) + 1);
    		
    		int week = b.get(Calendar.DAY_OF_WEEK);
    		if (week == 1 || week == 7)
    			break;
    	}
    	
    	
    	
    	Date d = b.getTime();
    	SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 EEEE");
    	System.out.println("시간 = " + fmt.format(d));
    	
    	//Calendar.SATURDAY
    	//Calendar.SUNDAY

    }
}