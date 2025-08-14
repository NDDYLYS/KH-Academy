package com.kh.spring05book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring05book.dao.BookDao;
import com.kh.spring05book.dto.BookDto;

@RestController
@RequestMapping("/book")
public class BookController 
{
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/add")
	public String add(@ModelAttribute BookDto bookDto) 
	{
		bookDao.insert(bookDto);
		return "서적 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute BookDto bookDto) 
	{
		boolean success = bookDao.update(bookDto);
		if (success)
			return "서적 수정 완료";
		else
			return "서적 수정 실패";
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam int bookId) 
	{
		boolean success = bookDao.delete(bookId);
		if (success)
			return "서적 삭제 완료";
		else
			return "서적 삭제 실패";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(required = false, defaultValue = "") String column, 
			@RequestParam(required = false, defaultValue = "") String keyword) 
	{
		List<BookDto> list = null;
		if (column.equals("") || keyword.equals(""))
			list = bookDao.selectList();
		else
			list = bookDao.selectSearch(column, keyword);
		
		StringBuffer buffer = new StringBuffer();		
		buffer.append("서적 수 : " + list.size() + "<br>");
		for(BookDto solo : list)
		{
			buffer.append(solo);
			buffer.append("<br>");			
		}
		
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId) 
	{
		BookDto bookDto = bookDao.selectOne(bookId);
		if (bookDto == null)
			return "존재하지 않는 서적입니다.";
			
		StringBuffer buffer = new StringBuffer();
	
		buffer.append(bookDto);
		buffer.append("<br>");
		
		return buffer.toString();
	}
}