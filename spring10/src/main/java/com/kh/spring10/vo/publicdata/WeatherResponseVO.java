package com.kh.spring10.vo.publicdata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class WeatherResponseVO {
	private int pageNo;
	private int numOfRows;
	private int totalCount;
	private List<WeatherItemVO> items;
	
}
