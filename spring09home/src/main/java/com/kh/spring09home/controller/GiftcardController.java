package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.BuyDao;
import com.kh.spring09home.dao.GiftcardDao;
import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.BuyDto;
import com.kh.spring09home.dto.GiftcardDto;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.TargetNotfoundException;

@Controller
@RequestMapping("/giftcard")
public class GiftcardController 
{
	@Autowired
	private BuyDao buyDao;
	@Autowired
	private GiftcardDao giftcardDao;
	@Autowired
	private MemberDao memberDao;

	@GetMapping("/buy")
	public String buy(Model model, @RequestParam int giftcardNo) 
	{		
		GiftcardDto giftcardDto = giftcardDao.selectOne(giftcardNo);
		if (giftcardDto == null)
			throw new TargetNotfoundException("구매하려는 상품권이 존재하지 않습니다");
		model.addAttribute("giftcardDto", giftcardDto);
		
		return "/WEB-INF/views/giftcard/buy.jsp";
	}
	
	@Transactional
	@PostMapping("/buy")
	public String buy(@ModelAttribute BuyDto buyDto) 
	{
		MemberDto memberDto = memberDao.selectOne(buyDto.getBuyMemberId());
		if (memberDto == null)
			throw new TargetNotfoundException("로그인한 회원이 존재하지 않습니다");
		GiftcardDto giftcardDto = giftcardDao.selectOne(buyDto.getBuyGiftcardNo());
		if (giftcardDto == null)
			throw new TargetNotfoundException("구매한 상품권이 존재하지 않습니다");
		
		int buyNo = buyDao.sequence();
		buyDto.setBuyNo(buyNo);
		buyDto.setBuyAmount(giftcardDto.getGiftcardPrice() * buyDto.getBuyQty());
		buyDao.insert(buyDto);
		
		int memberPoint = memberDto.getMemberPoint();
		memberDto.setMemberPoint(memberPoint + (giftcardDto.getGiftcardPoint() * buyDto.getBuyQty()));
		memberDao.update(memberDto);
		
		return "redirect:buyFinish";
	}
	
	@RequestMapping("/buyFinish")
	public String buyFinish() 
	{
		return "/WEB-INF/views/giftcard/buyFinish.jsp";
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
	

	@RequestMapping("/list")
	public String list(Model model) 
	{
		List<GiftcardDto> list = giftcardDao.list();
		model.addAttribute("giftcardList", list);
		return "/WEB-INF/views/giftcard/list.jsp";
	}
}
