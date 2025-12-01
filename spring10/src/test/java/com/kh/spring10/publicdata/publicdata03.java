package com.kh.spring10.publicdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kh.spring10.service.PublicDataService;
import com.kh.spring10.vo.publicdata.WeatherRequestVO;
import com.kh.spring10.vo.publicdata.WeatherResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class publicdata03 {
	@Autowired
	private PublicDataService publicDataService;
	
	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		WeatherRequestVO requestVO = WeatherRequestVO.builder()
					.baseDate("20251201")
					.baseTime("1600")
					.nx(55)
					.ny(127)
				.build();
		
		WeatherResponseVO responseVO = publicDataService.searchWeather(requestVO);
		log.debug("responseVO = {}", responseVO);
	}
}