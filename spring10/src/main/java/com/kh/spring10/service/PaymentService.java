package com.kh.spring10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring10.dao.GiftcardDao;
import com.kh.spring10.dao.PaymentDao;
import com.kh.spring10.dao.PaymentDetailDao;
import com.kh.spring10.dto.GiftcardDto;
import com.kh.spring10.dto.PaymentDetailDto;
import com.kh.spring10.dto.PaymentDto;
import com.kh.spring10.vo.kakaopay.KakaoPayApproveResponseVO;
import com.kh.spring10.vo.kakaopay.KakaoPayCancelResponseVO;
import com.kh.spring10.vo.kakaopay.KakaoPayFlashVO;
import com.kh.spring10.vo.kakaopay.KakaoPayQtyVO;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private PaymentDetailDao paymentDetailDao;
	@Autowired
	private GiftcardDao giftcardDao;
	
	@Transactional
	public void insert(KakaoPayApproveResponseVO responseVO,
								KakaoPayFlashVO flashVO) {
		long paymentNo = paymentDao.sequence();
		paymentDao.insert(PaymentDto.builder()
					.paymentNo(paymentNo)
					.paymentOwner(responseVO.getPartnerUserId())//구매자
					.paymentTid(responseVO.getTid())//거래번호
					.paymentName(responseVO.getItemName())//결제이름
					.paymentTotal(responseVO.getAmount().getTotal())//결제금액
					.paymentRemain(responseVO.getAmount().getTotal())//취소가능금액
				.build());
		//결제상세정보는 qtyList를 조회해서 생성하도록 처리
		for(KakaoPayQtyVO qtyVO : flashVO.getQtyList()) {
			long paymentDetailNo = paymentDetailDao.sequence();
			GiftcardDto giftcardDto = giftcardDao.selectOne(qtyVO.getNo());//상품조회
			paymentDetailDao.insert(PaymentDetailDto.builder()
						.paymentDetailNo(paymentDetailNo)//결제상세번호
						.paymentDetailOrigin(paymentNo)//결제대표번호
						.paymentDetailItemNo(qtyVO.getNo())//상품번호
						.paymentDetailItemName(giftcardDto.getGiftcardName())//상품명
						.paymentDetailItemPrice(giftcardDto.getGiftcardPrice())//판매가
						.paymentDetailQty(qtyVO.getQty())//구매수량
					.build());
		}
	}
	
	@Transactional
	public void cancel(long paymentNo) {
		paymentDao.cancelAll(paymentNo);
		paymentDetailDao.cancelAll(paymentNo);
	}

	@Transactional
	public void cancelUnit(PaymentDetailDto paymentDetailDto, KakaoPayCancelResponseVO responseVO) {
		paymentDao.cancelUnit(paymentDetailDto.getPaymentDetailOrigin(), 
											responseVO.getCancelAvailableAmount().getTotal());
		paymentDetailDao.cancelUnit(paymentDetailDto);
	}
	
}