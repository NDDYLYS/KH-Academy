package com.kh.spring10.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.GiftcardDao;
import com.kh.spring10.dto.GiftcardDto;

@CrossOrigin
@RestController
@RequestMapping("/giftcard")
public class GiftcardRestController {
	@Autowired
	private GiftcardDao giftcardDao;
	
	@GetMapping("/")
	public List<GiftcardDto> list(){
		return giftcardDao.selectList();
	}
	
	@GetMapping("/{giftcardNo}")
	public GiftcardDto detail(@PathVariable long giftcardNo){
		return giftcardDao.selectOne(giftcardNo);
	}
}