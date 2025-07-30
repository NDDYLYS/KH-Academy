package c250728api.time;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test05기념일계산기 
{
    public static void main(String[] args) 
    {
    	// 사용자에게 연, 월, 일을 입력 받아서 해당하는 날짜를 기준으로 기념일 계산 결과를 출력
    	// 100일, 200일, 300일, 1주년, 400일, 500일, 600일, 700일, 2주년
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("출생 연도를 입력해주세요. : ");
    	int year = sc.nextInt();
    	System.out.print("출생 월을 입력해주세요. : ");
    	int month = sc.nextInt();
    	System.out.print("출생 일자를 입력해주세요. : ");
    	int day = sc.nextInt();
    	
    	int[] anniversarys = new int[] {100, 200, 300, 365, 400, 500, 600, 700, 730};
    	
    	Calendar b = Calendar.getInstance();	
		b.set(Calendar.YEAR, year);
		b.set(Calendar.MONTH, month - 1);
		b.set(Calendar.DATE, day);
    	    	
    	Date d = b.getTime();
    	SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 EEEE");
    	System.out.println("현재 시간 = " + fmt.format(d));
    	
    	for(int i = 0; i < anniversarys.length; i++) 
    	{
    		b.set(year, month -1, day + anniversarys[i]);    		
    		
    		Date temp = b.getTime();
        	SimpleDateFormat temp3 = new SimpleDateFormat("y년 M월 d일 EEEE");
        	String name = "";
        	if (anniversarys[i] % 365 == 0)
        		name = anniversarys[i] / 365 + "주년";
        	else
        		name = (anniversarys[i] / 100) * 100 + "일";
        	
        	System.out.println("기념일[" + name + "] = " + temp3.format(temp));
    		
    	}
    }
}