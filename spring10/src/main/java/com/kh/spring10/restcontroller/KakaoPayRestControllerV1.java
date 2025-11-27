package com.kh.spring10.restcontroller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.service.KakaoPayService;
import com.kh.spring10.vo.KakaoPayApproveRequestVO;
import com.kh.spring10.vo.KakaoPayApproveResponseVO;
import com.kh.spring10.vo.KakaoPayFlashVO;
import com.kh.spring10.vo.KakaoPayReadyRequestVO;
import com.kh.spring10.vo.KakaoPayReadyResponseVO;
import com.kh.spring10.vo.TokenVO;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/kakaopay/v1")
public class KakaoPayRestControllerV1 {
	@Autowired
	private KakaoPayService kakaoPayService;
//	@Autowired
//	private TokenService tokenService;
	
	private Map<String, KakaoPayFlashVO> flashMap = Collections.synchronizedMap(new HashMap<>());
	
	@PostMapping("/buy")
	public KakaoPayReadyResponseVO buy(
		@RequestBody KakaoPayReadyRequestVO requestVO,
		@RequestAttribute TokenVO tokenVO//MemberInterceptor를 거쳐온 경우
//		@RequestHeader("Authorization") String bearerToken//직접 해석할 경우
	) {
		log.debug(requestVO.toString());
		log.debug(tokenVO.toString());
		//requestVO에는 상품명과 금액만 존재한다
		requestVO.setPartnerOrderId(UUID.randomUUID().toString());//주문번호
		requestVO.setPartnerUserId(tokenVO.getLoginId());//주문자
		//결제 준비 처리
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		flashMap.put(requestVO.getPartnerOrderId(), KakaoPayFlashVO.builder()
				.partnerOrderId(requestVO.getPartnerOrderId())
				.partnerUserId(requestVO.getPartnerUserId())
				.tid(responseVO.getTid())
				.returnUrl(null)
				.build());
		
		return responseVO;
	}
	
//	카카오에서 결제가 완료되면 자동으로 이동시킬 페이지
	@GetMapping("/buy/success/{partnerOrderId}")
	public void success(HttpServletResponse response,
			@RequestParam("pg_token") String pgToken, @PathVariable String partnerOrderId) throws IOException {
		log.debug("결제가 완료되었습니다!");
		
		KakaoPayFlashVO flashVO = flashMap.remove(partnerOrderId);
		
		
		KakaoPayApproveRequestVO requestVO = KakaoPayApproveRequestVO.builder()
					.partnerOrderId(flashVO.getPartnerOrderId())
					.partnerUserId(flashVO.getPartnerUserId())
					.tid(flashVO.getTid())
					.pgToken(pgToken)
				.build();
		
		KakaoPayApproveResponseVO responseVO = kakaoPayService.approve(requestVO);
		
		//사용자에게 보여줄 수 있는 화면으로 이동시켜야함 (redirect)
		response.sendRedirect("http://localhost:5173/kakaopay/v1/success");
		//response.sendRedirect(returnUrl + "/success");
	}
//	@GetMapping("/buy/cancel/{partnerOrderId}")
//	@GetMapping("/buy/fail/{partnerOrderId}")
}