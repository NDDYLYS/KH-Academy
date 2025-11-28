package com.kh.spring10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring10.dao.GiftcardDao;
import com.kh.spring10.dao.PaymentDao;
import com.kh.spring10.dao.PaymentDetailDao;

@Service
public class PaymentDetailService {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private PaymentDetailDao paymentDetailDao;
	@Autowired
	private GiftcardDao gifccardDao;
}
