package jdbc.update;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

;

public class Test03도서정보수정 
{
	 public static void main(String[] args) 
	 {
	    	BookDto bookDto = new BookDto();
	    	bookDto.setBookId(1999);
	    	bookDto.setBookTitle("수상라의");
	    	bookDto.setBookAuthor("이윤111석");
	    	bookDto.setBookPublicationDate("2025-08-08");
	    	bookDto.setBookPrice(44444);
	    	bookDto.setBookPublisher("대일뮨고");
	    	bookDto.setBookPageCount(333);
	    	bookDto.setBookGenre("판타지");
	    	
	    	BookDao bookDao = new BookDao();
	    	boolean success = bookDao.update(bookDto);
	    	if (success)
	    		System.out.println("수정 완료");
	    	else 
	    		System.out.println("수정 실패");
	}
}