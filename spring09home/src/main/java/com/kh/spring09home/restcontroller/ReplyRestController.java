package com.kh.spring09home.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09home.dao.ReplyDao;
import com.kh.spring09home.dto.ReplyDto;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {
	@Autowired
	private ReplyDao replyDao;
	
	
	@PostMapping("/list")
	public List<ReplyDto> list(@RequestParam int replyTarget)
	{
		return replyDao.selectList(replyTarget);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestParam int replyNo) 
	{
		replyDao.delete(replyNo);
	}
	
	@PostMapping("/write")
	public void write(@ModelAttribute ReplyDto replyDto,
			HttpSession session) 
	{
		int sequence = replyDao.sequence();
		replyDto.setReplyNo(sequence);
		String loginId = (String)session.getAttribute("loginId");
		replyDto.setReplyWriter(loginId);
		replyDao.insert(replyDto);
	}
}