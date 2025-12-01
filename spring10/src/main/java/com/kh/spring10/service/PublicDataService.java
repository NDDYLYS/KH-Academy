package com.kh.spring10.service;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring10.configurtion.PublicDataProperties;
import com.kh.spring10.vo.publicdata.WeatherItemVO;
import com.kh.spring10.vo.publicdata.WeatherRequestVO;
import com.kh.spring10.vo.publicdata.WeatherResponseVO;

@Service
public class PublicDataService {
	@Qualifier("publicdataWebClient")
	@Autowired
	private WebClient webClient;
	@Autowired
	private PublicDataProperties publicDataProperties;
	
	private final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
	
	@Autowired
	private ObjectMapper objectMapper;//JSON 변환 도구
	
	public WeatherResponseVO searchWeather(WeatherRequestVO requestVO) throws JsonMappingException, JsonProcessingException {
		URI uri = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("serviceKey", publicDataProperties.getKey())
                .queryParam("pageNo", requestVO.getPageNo())
                .queryParam("numOfRows", requestVO.getNumOfRows())
                .queryParam("dataType", "JSON") // XML 또는 JSON
                .queryParam("base_date", requestVO.getBaseDate())
                .queryParam("base_time", requestVO.getBaseTime())
                .queryParam("nx", requestVO.getNx()) // 예보지점의 X 좌표값 (예: 서울)
                .queryParam("ny", requestVO.getNy()) // 예보지점의 Y 좌표값 (예: 서울)
                .encode(StandardCharsets.UTF_8)
                .build()
            .toUri();
		
		String responseBody = webClient.get().uri(uri)
								.retrieve()
									.bodyToMono(String.class) // 응답 본문을 String 타입으로 받습니다.
									.block(); // 테스트 환경이므로 block()을 사용하여 동기적으로 결과를 기다립니다.
        //ObjectMapper를 이용해서 JSON문자열을 해석해서 클래스에 수동으로 저장
		JsonNode rootNode = objectMapper.readTree(responseBody);//전체를 읽어서
		JsonNode bodyNode = rootNode.path("response").path("body");//response→body로 이동
		JsonNode itemNode = bodyNode.path("items").path("item");
		//Generic Type까지 알려주면서 변환해야 하는 경우 사용하는 자료형 안내 객체
		TypeReference<List<WeatherItemVO>> typeRef = new TypeReference<>() {};
		
		WeatherResponseVO responseVO = WeatherResponseVO.builder()
					.pageNo(bodyNode.path("pageNo").asInt())//body에 있는 pageNo를 int로 뽑아라
					.numOfRows(bodyNode.path("numOfRows").asInt())
					.totalCount(bodyNode.path("totalCount").asInt())
					.items(objectMapper.convertValue(itemNode, typeRef))
				.build();
		
		return responseVO;
	}
}