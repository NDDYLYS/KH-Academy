package com.kh.spring10.restcontroller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.GiftcardDao;
import com.kh.spring10.dao.PaymentDao;
import com.kh.spring10.dao.PaymentDetailDao;
import com.kh.spring10.dto.GiftcardDto;
import com.kh.spring10.error.TargetNotfoundException;
import com.kh.spring10.service.KakaoPayService;
import com.kh.spring10.service.PaymentService;
import com.kh.spring10.service.TokenService;
import com.kh.spring10.vo.TokenVO;
import com.kh.spring10.vo.kakaopay.KakaoPayApproveRequestVO;
import com.kh.spring10.vo.kakaopay.KakaoPayApproveResponseVO;
import com.kh.spring10.vo.kakaopay.KakaoPayFlashVO;
import com.kh.spring10.vo.kakaopay.KakaoPayQtyVO;
import com.kh.spring10.vo.kakaopay.KakaoPayReadyRequestVO;
import com.kh.spring10.vo.kakaopay.KakaoPayReadyResponseVO;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/kakaopay/v2")
public class KakaoPayRestControllerV2 {
	@Autowired
	private KakaoPayService kakaoPayService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private GiftcardDao giftcardDao;
	@Autowired
	private PaymentService paymentService;
	
	private Map<String, KakaoPayFlashVO> flashMap = Collections.synchronizedMap(new HashMap<>());
	
	@PostMapping("/buy")
	public KakaoPayReadyResponseVO buy(@RequestBody List<KakaoPayQtyVO> qtyList, 
			@RequestHeader("Frontend-Url") String frontendUrl, 
//			@RequestAttribute TokenVO tokenVO
			@RequestHeader("Authorization") String bearerToken
	)
	{
		TokenVO tokenVO = tokenService.parse(bearerToken);
		
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
		
		flashMap.put(
				requestVO.getPartnerOrderId(),//주문번호(key)
				KakaoPayFlashVO.builder()//데이터(value)
						.partnerOrderId(requestVO.getPartnerOrderId())
						.partnerUserId(requestVO.getPartnerUserId())
						.tid(responseVO.getTid())
						.returnUrl(frontendUrl)
						.qtyList(qtyList)
					.build()
			);
		
		return responseVO;
	}
	
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
		
		paymentService.insert(responseVO, flashVO);
		
		//사용자에게 보여줄 수 있는 화면으로 이동시켜야함 (redirect)
		response.sendRedirect(flashVO.getReturnUrl() + "/success");
		//response.sendRedirect(returnUrl + "/success");
	}
	
	@GetMapping("/buy/cancel/{partnerOrderId}")
	public void cancel(HttpServletResponse response, @PathVariable String partnerOrderId) throws IOException {
		KakaoPayFlashVO flashVO = flashMap.remove(partnerOrderId);
		response.sendRedirect(flashVO.getReturnUrl() + "/cancel");		
	}

	@GetMapping("/buy/fail/{partnerOrderId}")
	public void fail(HttpServletResponse response, @PathVariable String partnerOrderId) throws IOException {
		KakaoPayFlashVO flashVO = flashMap.remove(partnerOrderId);
		response.sendRedirect(flashVO.getReturnUrl() + "/fail");
	}
	
	
}
