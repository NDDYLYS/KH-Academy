package com.kh.spring10.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.service.KakaoPayService;

@CrossOrigin
@RestController
@RequestMapping("/kakaopay/v2")
public class KakaoPayRestControllerv2 {
	@Autowired
	private KakaoPayService kakaoPayService;
}
