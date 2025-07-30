package c250728api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02Date형식변경 
{
    public static void main(String[] args) 
    {
    	// Date는 현재 시각을 구하는데 주로 사용
    	Date d = new Date();
    	System.out.println(d);
    	
    	// .java.text에 있는 SimpleDateFormat과 조합하면 형식이 변경 가능
    	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    	System.out.println("fmt : " + fmt.format(d));
    	
    	// 다음 형식으로 현재 시간을 출력
    	// 2025년 7월 29일 오후 12시 24분 30초
    	// 2025-07-29 화 12시 24분 30초
    	
    	SimpleDateFormat fmt2 = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
    	System.out.println("fmt2 : " + fmt2.format(d));
    	SimpleDateFormat fmt3 = new SimpleDateFormat("yyyy-MM-dd E H시 m분 s초");
    	System.out.println("fmt3 : " + fmt3.format(d));
    	SimpleDateFormat fmt4 = new SimpleDateFormat("yyyy년-MM월-dd일 HH시:mm분:ss초");
    	System.out.println("fmt4 : " + fmt4.format(d));
    }
}