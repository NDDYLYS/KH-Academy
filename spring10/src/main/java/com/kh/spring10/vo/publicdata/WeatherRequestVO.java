package com.kh.spring10.vo.publicdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class WeatherRequestVO {
	@Builder.Default
	private int pageNo = 1;
	@Builder.Default
	private int numOfRows = 1000;
	@Builder.Default
	public String dataType="JSON";
	public String baseDate;
	public String baseTime;
	private int nx, ny;
}
