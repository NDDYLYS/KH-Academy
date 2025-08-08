package jdbc.insert;

import java.util.Scanner;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

;

public class 도서등록프로그램 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("책의 이름을 입력해주세요 : ");
		String bookTitle = sc.nextLine();
		
		System.out.print("책의 저자를 입력해주세요 : ");
		String bookAuthor = sc.nextLine();
		
    	System.out.print("책의 출간일을 입력해주세요 : ");
    	String bookPublicationDate = sc.nextLine();
		
		System.out.print("책의 가격을 입력해주세요 : ");
		int bookPrice = sc.nextInt();
		sc.nextLine();
		
		System.out.print("책의 출판사를 입력해주세요 : ");
		String bookPublisher = sc.nextLine();
		
    	System.out.print("책의 페이지 수를 입력해주세요 : ");
    	int bookPageCount = sc.nextInt();
    	sc.nextLine();
		
		System.out.print("책의 장르를 입력해주세요 : ");
		String bookGenre = sc.nextLine();
  		
		sc.close();
		BookDto bookDto = new BookDto();
		bookDto.setBookTitle(bookTitle);
		bookDto.setBookAuthor(bookAuthor);
		bookDto.setBookPublicationDate(bookPublicationDate);
		bookDto.setBookPrice(bookPrice);
		bookDto.setBookPublisher(bookPublisher);
		bookDto.setBookPageCount(bookPageCount);
		bookDto.setBookGenre(bookGenre);
		
		BookDao bookDao = new BookDao();
		bookDao.insert(bookDto);
    }
}