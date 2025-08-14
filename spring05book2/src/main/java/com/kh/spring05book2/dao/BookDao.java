package com.kh.spring05book2.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring05book2.dto.BookDto;
import com.kh.spring05book2.mapper.BookMapper;

@Repository
public class BookDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookMapper bookMapper;
	
	public void insert(BookDto bookDto) 
	{
		String sql = "insert into book (book_id, book_title, book_author,"
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
	
	public boolean update(BookDto bookDto) 
	{                        
		String sql = "update book set book_title=?, book_author=?, "
    			+ "book_publication_date=?, book_price=?, book_publisher=?, book_page_count=?,"
    			+ "book_genre=? where book_id=?";
    	Object[] params = {bookDto.getBookTitle(), bookDto.getBookAuthor(), 
    			bookDto.getBookPublicationDate(), bookDto.getBookPrice(), bookDto.getBookPublisher(),
    			bookDto.getBookPageCount(), bookDto.getBookGenre(), bookDto.getBookId()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int bookId) 
	{
		String sql = "delete book where book_id=?";
    	Object[] params = {bookId};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<BookDto> selectSearch(String column, String keyword)
	{
		Set<String> allowList = Set.of("book_title", "book_author");
		
		if (allowList.contains(column) == false)
			return List.of(); // 비어있는 리스트;	
		
		String sql = "select * from book where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, book_id asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	
	public List<BookDto> selectList()
	{
		String sql = "select * from book order by book_id asc";
    	return jdbcTemplate.query(sql, bookMapper);
	}
	
	public BookDto selectOne(int bookId) 
	{
		String sql = "select * from book where book_id = ?";
		Object[] params = {bookId};
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
}
