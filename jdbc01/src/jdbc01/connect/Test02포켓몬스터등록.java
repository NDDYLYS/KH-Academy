package jdbc01.connect;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

;

public class Test02포켓몬스터등록 
{
    public static void main(String[] args) 
    {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh16");
		dataSource.setPassword("kh16");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) 
    	{
    		System.out.print("이름을 입력해주세요 : ");
    		String name = sc.nextLine();
    		if (name.equals("종료"))
    			break;    		
    		
    		System.out.print("속성을 입력해주세요 : ");
    		String attribute = sc.nextLine();
      		if (attribute.equals("종료"))
    			break;  
    		
    		String insertinto = "insert into pokemon (pokemon_no, pokemon_name, pokemon_type) values (pokemon_seq.nextval, '" + name + "', '" + attribute + "')";
    		jdbcTemplate.update(insertinto);
    		
    		System.out.println("포켓몬 " + name + "가 입력되었습니다.");
    	}
    	
    	sc.close();
    }
}