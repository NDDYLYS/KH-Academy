package com.kh.spring10.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayFlashVO {
	private String partnerOrderId;
	private String partnerUserId;
	private String tid;
	private String returnUrl;
	
}
