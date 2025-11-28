package com.kh.spring10.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.PaymentDao;
import com.kh.spring10.dto.PaymentDto;
import com.kh.spring10.error.NeedPermissionException;
import com.kh.spring10.error.TargetNotfoundException;
import com.kh.spring10.service.KakaoPayService;
import com.kh.spring10.vo.KakaoPayOrderRequestVO;
import com.kh.spring10.vo.KakaoPayOrderResponseVO;
import com.kh.spring10.vo.TokenVO;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentRestController {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private KakaoPayService kakaoPayService;
	
//	@GetMapping("/")//전체목록
//	@GetMapping("/{paymentNo}")//상세정보
	@GetMapping("/account")
	public List<PaymentDto> listByOwner(@RequestAttribute TokenVO tokenVO) {
		return paymentDao.selectList(tokenVO);
	}
	
	@GetMapping("/{paymentNo}")
	public KakaoPayOrderResponseVO detail (@PathVariable long paymentNo, 
			@RequestAttribute TokenVO tokenVO) 
	{
		PaymentDto paymentDto = paymentDao.selectOne(paymentNo);
		if (paymentDto == null)
			throw new TargetNotfoundException();
		
		boolean isOwner = paymentDto.getPaymentOwner().equals(tokenVO.getLoginId());
		if(isOwner == false) 
			throw new NeedPermissionException();
		
		return kakaoPayService.order(KakaoPayOrderRequestVO.builder()
					.tid(paymentDto.getPaymentTid())
				.build());
		
	}
}
