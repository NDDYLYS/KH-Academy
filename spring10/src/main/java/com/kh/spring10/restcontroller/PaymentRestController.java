package com.kh.spring10.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.PaymentDao;
import com.kh.spring10.dao.PaymentDetailDao;
import com.kh.spring10.dto.PaymentDetailDto;
import com.kh.spring10.dto.PaymentDto;
import com.kh.spring10.error.NeedPermissionException;
import com.kh.spring10.error.TargetNotfoundException;
import com.kh.spring10.service.KakaoPayService;
import com.kh.spring10.service.PaymentService;
import com.kh.spring10.vo.TokenVO;
import com.kh.spring10.vo.kakaopay.KakaoPayCancelRequestVO;
import com.kh.spring10.vo.kakaopay.KakaoPayCancelResponseVO;
import com.kh.spring10.vo.kakaopay.KakaoPayOrderRequestVO;
import com.kh.spring10.vo.kakaopay.KakaoPayOrderResponseVO;
import com.kh.spring10.vo.kakaopay.PaymentInfoVO;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentRestController {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private PaymentDetailDao paymentDetailDao;
	@Autowired
	private KakaoPayService kakaoPayService;
	@Autowired
	private PaymentService paymentService;
	
//	@GetMapping("/")//전체목록
	@GetMapping("/account")
	public List<PaymentDto> listByOwner(@RequestAttribute TokenVO tokenVO) {
		return paymentDao.selectList(tokenVO);
	}
	
	@GetMapping("/{paymentNo}")//상세정보
	public PaymentInfoVO detail(@PathVariable long paymentNo,
				@RequestAttribute TokenVO tokenVO) {
		PaymentDto paymentDto = paymentDao.selectOne(paymentNo);
		if(paymentDto == null) throw new TargetNotfoundException();
		
		boolean isOwner = paymentDto.getPaymentOwner().equals(tokenVO.getLoginId());
		if(isOwner == false) throw new NeedPermissionException();
		
		List<PaymentDetailDto> paymentDetailList = paymentDetailDao.selectList(paymentNo);
		
		KakaoPayOrderResponseVO responseVO =  kakaoPayService.order(
						KakaoPayOrderRequestVO.builder()
							.tid(paymentDto.getPaymentTid())
						.build());
		
		//정보들을 모두 취합해서 반환
		return PaymentInfoVO.builder()
					.paymentDto(paymentDto)
					.paymentDetailList(paymentDetailList)
					.responseVO(responseVO)
				.build();
	}
	
	@DeleteMapping("/{paymentNo}")//결제 대표정보 취소
	public void cancel(@PathVariable long paymentNo,
					@RequestAttribute TokenVO tokenVO) {
		//결제 대표 정보를 조회
		PaymentDto paymentDto = paymentDao.selectOne(paymentNo);
		if(paymentDto == null) throw new TargetNotfoundException();
		
		//본인 정보인지 확인
		boolean isOwner = paymentDto.getPaymentOwner().equals(tokenVO.getLoginId());
		if(isOwner == false) throw new NeedPermissionException();
		
		//카카오페이 취소
		KakaoPayCancelRequestVO requestVO = KakaoPayCancelRequestVO.builder()
					.tid(paymentDto.getPaymentTid())
					.cancelAmount(paymentDto.getPaymentRemain())
				.build();
		KakaoPayCancelResponseVO responseVO = kakaoPayService.cancel(requestVO);
		
		//DB 처리 (잔여금액을 변경, 세부항목들의 상태 변경)
		paymentService.cancel(paymentNo);
	}
	@DeleteMapping("/detail/{paymentDetailNo}")//결제 상세정보 취소
	public void cancelUnit(@PathVariable long paymentDetailNo,
										@RequestAttribute TokenVO tokenVO) {
		PaymentDetailDto paymentDetailDto = paymentDetailDao.selectOne(paymentDetailNo);
		if(paymentDetailDto == null) throw new TargetNotfoundException();
		
		PaymentDto paymentDto = paymentDao.selectOne(paymentDetailDto.getPaymentDetailOrigin());
		if(paymentDto == null) throw new TargetNotfoundException();
		
		//본인 정보인지 확인
		boolean isOwner = paymentDto.getPaymentOwner().equals(tokenVO.getLoginId());
		if(isOwner == false) throw new NeedPermissionException();
		
		//이미 취소된 상품인지 검사
		if(paymentDetailDto.getPaymentDetailStatus().equals("취소"))
			throw new NeedPermissionException();
		
		//카카오페이 취소
		KakaoPayCancelRequestVO requestVO = KakaoPayCancelRequestVO.builder()
					.tid(paymentDto.getPaymentTid())
					.cancelAmount(paymentDetailDto.getPaymentDetailTotal())
				.build();
		KakaoPayCancelResponseVO responseVO = kakaoPayService.cancel(requestVO);
		
		//DB처리
		paymentService.cancelUnit(paymentDetailDto, responseVO);
	}
}