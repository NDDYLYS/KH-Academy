package com.kh.spring09home.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BuyDto 
{
	private int buyNo;
	private String buyMemberId;
	private int buyGiftcardNo;
	private String buyGiftcardName;
	private Timestamp buyTime;
	private int buyQty;
	private int buyAmount;
}
