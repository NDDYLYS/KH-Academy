package jdbc01.connect;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03학생정보등록2 
{
    public static void main(String[] args) 
    {
    	OracleConnector connector = new OracleConnector();
		
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) 
    	{
    		System.out.print("이름을 입력해주세요 : ");
    		String name = sc.nextLine();
    		if (name.equals("종료"))
    			break;    		
    		
    		System.out.print("국어 점수를 입력해주세요 : ");
    		int korean = sc.nextInt();
    		
    		System.out.print("영어 점수를 입력해주세요 : ");
    		int english = sc.nextInt();
    		
    		System.out.print("수학 점수를 입력해주세요 : ");
    		int math = sc.nextInt();
    		
    		String insertinto = "insert into student (student_no, student_name, student_kor, student_eng, student_mat, student_reg) values (student_seq.nextval, ?, ?, ?, ?, systimestamp)";
    		Object[] param = {name, korean, english, math};
    		connector.Run_Sql(insertinto, param);
    		
    		System.out.println("학생(" + name + ")가 입력되었습니다.");
    		sc.nextLine();
    	}
    	
    	sc.close();
    }
}