package jdbc02;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class OracleConnector 
{
	private JdbcTemplate jdbcTemplate;
	
	public OracleConnector() 
	{
		Init();		
	}
	
	private void Init() 	
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh16");
		dataSource.setPassword("kh16");		
		
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void Run_Sql(String sql, Object[] params) 
	{
		jdbcTemplate.update(sql, params);
	}
}