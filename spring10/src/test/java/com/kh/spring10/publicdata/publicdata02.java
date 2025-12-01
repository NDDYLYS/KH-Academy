package com.kh.spring10.publicdata;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * WebClient를 사용하여 기상청 초단기실황 조회 API를 호출하는 테스트 예제입니다.
 *
 * 이 테스트를 실행하려면 실제 유효한 서비스 키가 필요합니다.
 * @SpringBootTest 어노테이션을 사용하여 Spring Application Context를 로드합니다.
 */
@Slf4j
@SpringBootTest
public class publicdata02 {

    // WebClient.Builder를 주입받아 API 호출에 사용할 WebClient 인스턴스를 생성합니다.
    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    
//     인코딩된 키 또는 디코딩된 키 모두 사용 가능합니다.
// 		공공데이터는 %인코딩이 완료된 키를 주지만 SpringBoot는 자체변환을 하므로 원본을 써야함   
// private final String SERVICE_KEY = "B5K%2FWhfF5ybLmPWVSNvy0TlaKL2wAHx9c4Uiy7rBDqVA0XF9E9H7NKwwZTi5QGuPgTjEhiLARhYbmFzkzvZlww%3D%3D";
    private final String SERVICE_KEY = "B5K/WhfF5ybLmPWVSNvy0TlaKL2wAHx9c4Uiy7rBDqVA0XF9E9H7NKwwZTi5QGuPgTjEhiLARhYbmFzkzvZlww==";

    @Test
    void testWeatherApiCallWithWebClient() {
        // 1. UriComponentsBuilder를 사용하여 URL 및 쿼리 파라미터를 구성합니다.
        // WebClient는 내부적으로 URL 인코딩을 처리하므로 URLEncoder.encode()를 명시적으로 사용할 필요가 줄어듭니다.
        URI uri = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "1000")
                .queryParam("dataType", "JSON") // XML 또는 JSON
                .queryParam("base_date", "20251201")
                .queryParam("base_time", "1300")
                .queryParam("nx", "55") // 예보지점의 X 좌표값 (예: 서울)
                .queryParam("ny", "127") // 예보지점의 Y 좌표값 (예: 서울)
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();

        // WebClient 인스턴스를 생성합니다.
        WebClient webClient = webClientBuilder.build();

        // 2. WebClient를 사용하여 GET 요청을 수행하고 응답을 동기적으로 받습니다 (테스트 목적).
        // .retrieve() 이후 에러 처리(.onStatus)를 추가하여 4xx/5xx 응답 시 예외를 발생시킵니다.
        String responseBody = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class) // 응답 본문을 String 타입으로 받습니다.
                .block(); // 테스트 환경이므로 block()을 사용하여 동기적으로 결과를 기다립니다.
        
     // 3. 결과 출력 및 검증
        System.out.println("==================================================================================");
        System.out.println("API 호출 URI: " + uri);
        System.out.println("API 응답 본문 (XML):\n" + responseBody.substring(0, Math.min(responseBody.length(), 500)) + "...");
        System.out.println("==================================================================================");

//         결과 검증: 응답 본문이 null이 아니어야 하고, XML 응답 구조를 포함해야 합니다.
        Assertions.assertNotNull(responseBody, "응답 본문은 null이 아니어야 합니다.");
//         서비스키가 유효한 경우	, 정상 응답(XML)이 포함되어야 합니다.
//        Assertions.assertTrue(responseBody.contains("<response>") || responseBody.contains("SERVICE_KEY_IS_NOT_REGISTERED_ERROR"), 
//                            "응답은 XML 형식의 <response>를 포함하거나 키 오류 메시지를 포함해야 합니다.");
    }
}