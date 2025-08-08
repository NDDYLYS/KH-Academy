package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import jdbc.dto.BookDto;
import jdbc.insert.JDBCHelper;

public class BookDao 
{
	public void insert(BookDto bookDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		
		String sql = "insert into pokemon (book_id, book_title, book_author,"
				+ "book_publication_date, book_price, book_publisher,"
				+ "book_page_count, book_genre) "
				+ "values (book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {bookDto.getBookTitle(), 
				bookDto.getBookAuthor(),
				bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(),
				bookDto.getBookPublisher(),
				bookDto.getBookPageCount(),
				bookDto.getBookGenre()};
		jdbcTemplate.update(sql, params);
	}
}