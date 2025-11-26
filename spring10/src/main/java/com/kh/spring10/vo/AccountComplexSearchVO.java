package com.kh.spring10.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true) // 존재하지 않으면 에러가 난다
@JsonNaming(PropertyNamingStrategies.UpperSnakeCaseStrategy.class) //언더바를 카멜케이스로 바꿔준다
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountComplexSearchVO {
	private String accountId;
	private String accountNickname;
	private String accountEmail;
	private String accountContact;
	private String accountBirth;
	private Integer minAccountPoint;
	private Integer maxAccountPoint;
	private String beginAccountJoin;
	private String endAccountJoin;
	private List<String> addressLevelList;
	private String accountAddress;
}
