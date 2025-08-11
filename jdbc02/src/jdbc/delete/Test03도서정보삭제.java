package jdbc.delete;

import jdbc.dao.BookDao;

public class Test03도서정보삭제 
{
    public static void main(String[] args) 
    {
    	int bookId = 9999;
    	
    	BookDao bookDao = new BookDao();
    	boolean success = bookDao.delete(bookId);
    	if (success)
    		System.out.println("삭제 완료");
    	else 
    		System.out.println("삭제 실패");
    }
}