package com.kh.spring09home.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09home.dao.GiftcardDao;
import com.kh.spring09home.dto.GiftcardDto;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.service.AttachmentService;

@Controller
@RequestMapping("/admin/giftcard")
public class AdminGiftCardController 
{
	@Autowired
	private GiftcardDao giftcardDao;
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping("/add")
	public String add() 
	{
		return "/WEB-INF/views/admin/giftcard/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute GiftcardDto giftcardDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException 
	{
		int giftcardNo = giftcardDao.sequence();
		giftcardDto.setGiftcardNo(giftcardNo);
		giftcardDao.add(giftcardDto);
		
		if(!attach.isEmpty()) 
		{
			int attachmentNo = attachmentService.save(attach);
			giftcardDao.connect(giftcardNo, attachmentNo);
		}
		else
		{
			return "redirect:add?error";
		}
		
		return "redirect:list";
	}
	
	@GetMapping("/edit")
	public String edit(Model model,
			@RequestParam int giftcardNo)
	{
		GiftcardDto giftcardDto = giftcardDao.selectOne(giftcardNo);
		if (giftcardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 상품권");
		
		model.addAttribute("giftcardDto", giftcardDto);
		return "/WEB-INF/views/admin/giftcard/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute GiftcardDto giftcardDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException 
	{
		if (!attach.isEmpty())
		{
			try 
			{
				int attachmentNo = giftcardDao.findAttachment(giftcardDto.getGiftcardNo());
				attachmentService.delete(attachmentNo);
			}
			catch(Exception e) { /*아무것도 안함*/ }
			
			int attachmentNo = attachmentService.save(attach);
			giftcardDao.connect(giftcardDto.getGiftcardNo(), attachmentNo);
		}
		
		giftcardDao.edit(giftcardDto);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int giftcardNo) 
	{
		GiftcardDto giftcardDto = giftcardDao.selectOne(giftcardNo);
		if (giftcardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 상품권");
		
		try 
		{
			int attachmentNo = giftcardDao.findAttachment(giftcardNo);
			attachmentService.delete(attachmentNo);
		}
		catch(Exception e) { /*아무것도 안함*/ }		
		
		giftcardDao.delete(giftcardNo);
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) 
	{
		List<GiftcardDto> list = giftcardDao.list();
		model.addAttribute("giftcardList", list);
		return "/WEB-INF/views/admin/giftcard/list.jsp";
	}
	
	@GetMapping("/image")
	public String image(@RequestParam int giftcardNo) 
	{
		try 
		{
			int attachmentNo = giftcardDao.findAttachment(giftcardNo);
			return "redirect:/attachment/download?attachmentNo=" + attachmentNo;			
		}
		catch(Exception e) 
		{
			return "redirect:/images/error/no-image.png";
		}
	}
	
	@GetMapping("/deleteAll")
	public String deleteAll(@RequestParam(value = "giftcardNo") List<Integer> giftcardNoList) 
	{
		for(int giftcardNo : giftcardNoList) 
		{
			GiftcardDto giftcardDto = giftcardDao.selectOne(giftcardNo);
			if (giftcardDto == null) 
				throw new TargetNotfoundException("존재하지 않는 상품권");
			
			try 
			{
				int attachmentNo = giftcardDao.findAttachment(giftcardNo);
				attachmentService.delete(attachmentNo);
			}
			catch(Exception e) { /*아무것도 안함*/ }		
			
			giftcardDao.delete(giftcardNo);
		}
		return "redirect:list";
	}
}
