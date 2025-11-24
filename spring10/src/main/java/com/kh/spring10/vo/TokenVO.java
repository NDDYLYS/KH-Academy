package com.kh.spring10.vo;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class TokenVO {
	private String loginId;
	private String loginLevel;
}