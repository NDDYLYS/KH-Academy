package com.kh.spring10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentDetailDto {
	private Long paymentDetailNo;
	private Long paymentDetailOrigin;
	private Long paymentDetailItemNo;
	private String paymentDetailItemName;
	private Integer paymentDetailItemPrice;
	private Integer paymentDetailQty;
}
