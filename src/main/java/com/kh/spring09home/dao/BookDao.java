package com.kh.spring09home.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.BookDto;
import com.kh.spring09home.mapper.BookMapper;
import com.kh.spring09home.vo.PageVO;

@Repository
public class BookDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookMapper bookMapper;
	
	public int sequence() 
	{
		String sql = "select book_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(BookDto bookDto) 
	{
		String sql = "insert into book (book_id, book_title, book_author,"
				+ "book_publication_date, book_price, book_publisher,"
				+ "book_page_count, book_genre) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				bookDto.getBookId(),
				bookDto.getBookTitle(), 
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
	
	public List<BookDto> selectList(String column, String keyword)
	{
		Set<String> allowList = Set.of("book_title", "book_author", "book_publisher");
		
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
	
	public int count(PageVO pageVO) 
	{
		if(pageVO.isList()) 
		{
			String sql ="select count(*) from book";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		else 
		{
			String sql ="select count(*) from book "
					+ "where instr(#1, ?) > 0";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, params);
		}
	}

	public List<BookDto> selectListWithPaging(PageVO pageVO) 
	{
		if(pageVO.isList()) 
		{//목록이라면
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
						+ "select * from book "
						+ "order by book_id desc"
					+ ")TMP"
				+ ") where rn between ? and ?";
			Object[] params = {
					pageVO.getBegin(), pageVO.getEnd()
			};//동적할당
			return jdbcTemplate.query(sql, bookMapper, params);
		}
		else 
		{//검색이라면
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from book "
									+ "where instr(#1, ?) > 0 "
									+ "order by #1 asc, book_id desc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {
					pageVO.getKeyword(), pageVO.getBegin(), pageVO.getEnd()
			};//동적할당
			return jdbcTemplate.query(sql, bookMapper, params);
		}
	}
	
	public void connect(int bookId, int attachmentNo) 
	{
		String sql = "insert into book_image (book_id, attachment_no) values (?, ?)";
		Object[] params = {
				bookId, 
				attachmentNo
		};//동적할당
		jdbcTemplate.update(sql, params);
	}
	
	public int findAttachment(int bookId) 
	{
		String sql = "select attachment_no from book_image where book_id = ?";
		Object[] params = {bookId};
		return jdbcTemplate.queryForObject(sql, int.class, params);
	}
}
