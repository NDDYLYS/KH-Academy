package com.kh.spring10.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentDto {
	private Long paymentNo;
	private String paymentOwner;
	private String paymentTid;
	private String paymentName;
	private Integer paymentTotal;
	private Integer paymentRemain;
	private LocalDateTime paymentTime;
}
