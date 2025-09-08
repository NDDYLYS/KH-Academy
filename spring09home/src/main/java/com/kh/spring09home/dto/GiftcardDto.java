package com.kh.spring09home.dto;

import lombok.Data;

@Data
public class GiftcardDto 
{
	private int giftcardNo;
	private String giftcardName;
	private String giftcardContent;
	private int giftcardPrice;
	private int giftcardPoint;
}
