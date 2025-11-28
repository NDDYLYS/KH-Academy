package com.kh.spring10.restcontroller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.GiftcardDao;
import com.kh.spring10.dto.GiftcardDto;
import com.kh.spring10.error.TargetNotfoundException;
import com.kh.spring10.service.KakaoPayService;
import com.kh.spring10.vo.KakaoPayQtyVO;
import com.kh.spring10.vo.KakaoPayReadyRequestVO;
import com.kh.spring10.vo.KakaoPayReadyResponseVO;
import com.kh.spring10.vo.TokenVO;

@CrossOrigin
@RestController
@RequestMapping("/kakaopay/v2")
public class KakaoPayRestControllerV2 {
	@Autowired
	private KakaoPayService kakaoPayService;
	@Autowired
	private GiftcardDao giftcardDao;
	
	@PostMapping("/buy")
	public KakaoPayReadyResponseVO buy(@RequestBody List<KakaoPayQtyVO> qtyList, 
			@RequestHeader("Frontend-Url") String frontendUrl, 
			@RequestAttribute TokenVO tokenVO)
	{
		if (qtyList == null || qtyList.isEmpty())
			throw new TargetNotfoundException();
		
		StringBuffer buffer = new StringBuffer();
		int total = 0;
		for(KakaoPayQtyVO qtyVO : qtyList) 
		{
			GiftcardDto giftcardDto = giftcardDao.selectOne(qtyVO.getNo());
			if (buffer.isEmpty())
				buffer.append(giftcardDto.getGiftcardName());
			
			total += giftcardDto.getGiftcardPrice() * qtyVO.getQty();
		}
		
		if (qtyList.size() >= 2) 
		{
			buffer.append("  외");
			buffer.append(qtyList.size() - 1);
			buffer.append("건");
		}

		KakaoPayReadyRequestVO requestVO = KakaoPayReadyRequestVO.builder()
				.partnerOrderId(UUID.randomUUID().toString())
				.partnerUserId(tokenVO.getLoginId())
				.itemName(buffer.toString())
				.totalAmount(total)
				.build();
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		return responseVO;
		
	}
}
