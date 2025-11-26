package com.kh.spring10.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//회원에 대한 복합 검색 요청 VO
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)//언더바를 카멜케이스로 자동변환
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountComplexSearchVO {
	private String accountId;
	private String accountNickname;
	private String accountEmail;
	private String accountContact;
	private String accountBirth;
	private Integer minAccountPoint, maxAccountPoint;
	private String beginAccountJoin, endAccountJoin;
	private List<String> accountLevelList;	
	private String accountAddress;
	//주소를 분할하여 반환하는 추가 Getter 메소드
	public Set<String> getAddressTokenList() {
		if(accountAddress == null) return null;
		
//		if(accountAddress.matches("^\\s+$")) return null;
		String stripResult = accountAddress.strip();
		if(stripResult.isEmpty()) return null;
		
		String[] tokens = stripResult.split("\\s+");//분할
		//String[] → Set<String>
		Set<String> set = Arrays.stream(tokens).collect(Collectors.toSet());
		
		return set;
	}
}