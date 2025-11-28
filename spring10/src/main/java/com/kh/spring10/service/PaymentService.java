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
import com.kh.spring10.vo.KakaoPayApproveResponseVO;
import com.kh.spring10.vo.KakaoPayFlashVO;
import com.kh.spring10.vo.KakaoPayQtyVO;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private PaymentDetailDao paymentDetailDao;
	@Autowired
	private GiftcardDao giftcardDao;
	
	@Transactional
	public void insert(KakaoPayApproveResponseVO responseVO, KakaoPayFlashVO flashVO) 
	{
		// DB 저장
		long paymentNo = paymentDao.sequence();
		paymentDao.insert(PaymentDto.builder()
				.paymentNo(paymentNo)
				.paymentOwner(responseVO.getPartnetUserId())
				.paymentTid(responseVO.getTid())
				.paymentName(responseVO.getItemName())
				.paymentTotal(responseVO.getAmount().getTotal())
				.paymentRemain(responseVO.getAmount().getTotal())
				.build());
		
		
		for(KakaoPayQtyVO qtyVO : flashVO.getQtyList()) 
		{
			long paymentDetailNo =  paymentDetailDao.sequence();
			GiftcardDto giftcartDto = giftcardDao.selectOne(qtyVO.getNo());
			paymentDetailDao.insert(PaymentDetailDto.builder()
					.paymentDetailNo(paymentDetailNo)
					.paymentDetailOrigin(paymentNo)
					.paymentDetailItemNo(qtyVO.getNo())
					.paymentDetailItemName(giftcartDto.getGiftcardName())
					.paymentDetailItemPrice(giftcartDto.getGiftcardPrice())
					.paymentDetailQty(qtyVO.getQty())
					.build());
		}
	}
}
