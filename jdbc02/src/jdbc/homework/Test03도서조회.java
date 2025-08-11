package jdbc.homework;

import java.util.List;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03도서조회 
{
    public static void main(String[] args) 
    {
    	BookDao bookDao = new BookDao();
    	List<BookDto> list = bookDao.selectList();
    	
    	System.out.println("조회 결과 : " + list.size() + "개");
    	for (BookDto bookDto : list) 
    	{
    		System.out.println(bookDto);
    	}
    }
}