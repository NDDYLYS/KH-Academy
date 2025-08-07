package jdbc01.connect;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

;

public class Test01연결테스트 
{
	public static void main(String[] args) 
	{
		// 연결 도구를 사용하여 필요한 정보를 전달하고 연결을 관리하도록 위임
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh16");
		dataSource.setPassword("kh16");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "delete product";
		
		// 실행
		jdbcTemplate.update(sql);
		
		System.out.println("실행 완료!");
	}
}