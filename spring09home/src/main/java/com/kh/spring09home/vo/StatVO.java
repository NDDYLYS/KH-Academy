package com.kh.spring09home.vo;

import lombok.Data;

// Value Object
// 테이블이 아닌 데이터를 내 입맛에 맞게 모아서 사용하고자 할 때 만드는 클래스
@Data
public class StatVO 
{
	private String title;
	private double value;
}