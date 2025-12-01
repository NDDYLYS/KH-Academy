package com.kh.spring10.vo.publicdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class WeatherItemVO {
	public String baseDate;
	public String baseTime;
	public String category;
	private int nx, ny;
	private float obsrValue;
}
