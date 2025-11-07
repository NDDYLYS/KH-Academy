package com.kh.spring09home.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09home.dao.BookDao;
import com.kh.spring09home.dto.BookDto;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.service.AttachmentService;
import com.kh.spring09home.vo.PageVO;

@Controller
@RequestMapping("/book") //
public class BookController 
{
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AttachmentService attachmentService;
	
	// (+추가) 이 콘트롤러로 들어오는 empty string은 null이다
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) 
//	{
//		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//	}
	
	@GetMapping("/save")
	public String save() 
	{
		return "/WEB-INF/views/book/save.jsp";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute BookDto bookDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException 
	{
		int bookId = bookDao.sequence();
		bookDto.setBookId(bookId);
		bookDao.insert(bookDto);
		
		if(!attach.isEmpty()) 
		{
			int attachmentNo = attachmentService.save(attach);
			bookDao.connect(bookId, attachmentNo);
		}
		
		return "redirect:saveFinish";
	}
	
	@RequestMapping("/saveFinish")
	public String saveFinish() 
	{
		return "/WEB-INF/views/book/saveFinish.jsp";
	}
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute(value = "pageVO") PageVO pageVO) 
	{
		model.addAttribute("bookList", bookDao.selectListWithPaging(pageVO));
		pageVO.setDataCount(bookDao.count(pageVO));
		model.addAttribute("pageVO", pageVO); // @ModelAttribute에 value 설정시 생략 가능
		
		return "/WEB-INF/views/book/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
			@RequestParam int bookId) 
	{
		BookDto bookDto = bookDao.selectOne(bookId);
		model.addAttribute("bookDto", bookDto);
		
		return "/WEB-INF/views/book/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(Model model,
			@RequestParam int bookId)
	{
		BookDto bookDto = bookDao.selectOne(bookId);
		if (bookDto == null) 
			throw new TargetNotfoundException("존재하지 않는 도서 번호");
		
		model.addAttribute("bookDto", bookDto);
		return "/WEB-INF/views/book/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BookDto bookDto) 
	{
		bookDao.update(bookDto);
		return "redirect:detail?bookId=" + bookDto.getBookId();
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam int bookId)
	{
		BookDto bookDto = bookDao.selectOne(bookId);
		if (bookDto == null) 
			throw new TargetNotfoundException("존재하지 않는 도서 번호");
		
		bookDao.delete(bookId);
		return "redirect:list";
	}
	
	@GetMapping("/image")
	public String image(@RequestParam int bookId) 
	{
		try 
		{
			int attachmentNo = bookDao.findAttachment(bookId);
			return "redirect:/attachment/download?attachmentNo=" + attachmentNo;			
		}
		catch(Exception e) 
		{
			return "redirect:/images/error/no-image.png";
		}
	}
}