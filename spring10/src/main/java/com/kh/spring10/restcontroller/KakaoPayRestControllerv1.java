package com.kh.spring10.restcontroller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.service.KakaoPayService;
import com.kh.spring10.vo.KakaoPayApproveRequestVO;
import com.kh.spring10.vo.KakaoPayApproveResponseVO;
import com.kh.spring10.vo.KakaoPayReadyRequestVO;
import com.kh.spring10.vo.KakaoPayReadyResponseVO;
import com.kh.spring10.vo.TokenVO;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/kakaopay/v1")
public class KakaoPayRestControllerv1 {
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@PostMapping("/buy")
	public KakaoPayReadyResponseVO buy(@RequestBody KakaoPayReadyRequestVO requestVO,
			@RequestAttribute TokenVO tokenVO) {
		
		requestVO.setPartnerOrderId(UUID.randomUUID().toString());
		requestVO.setPartnerUserId(tokenVO.getLoginId());
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		return responseVO;
	}
	
	@GetMapping("/buy/success")
//	@GetMapping("/buy/cancel")
//	@GetMapping("/buy/fail")
	public void success(HttpServletResponse response) throws IOException {
		log.debug("purchased complete.");
		
		KakaoPayApproveRequestVO requestVO = KakaoPayApproveRequestVO.builder()
				.partnerOrderId(null)
				.partnerUserId(null)
				.tid(null)
				.pgToken(null)
				.build();
		
		KakaoPayApproveResponseVO responseVO = kakaoPayService.approve(requestVO);
		
		
		//response.sendRedirect("http://localhost:5173/kakaopay/v1/success");
		response.sendRedirect(returnUrl + "/success");
	}
}
