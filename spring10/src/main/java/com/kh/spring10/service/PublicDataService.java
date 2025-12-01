package com.kh.spring10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kh.spring10.configurtion.PublicDataProperties;
import com.kh.spring10.vo.publicdata.WeatherRequestVO;
import com.kh.spring10.vo.publicdata.WeatherResponseVO;

@Service
public class PublicDataService {
	@Qualifier("publicdataWebClient")
	@Autowired
	private WebClient webClient;
	@Autowired
	private PublicDataProperties publicdataProperties;
	
	public WeatherResponseVO searchWeaher(WeatherRequestVO requestVO) {
		
	}
}