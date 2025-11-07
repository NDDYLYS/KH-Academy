package com.kh.spring09home.dto;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;


@Data
public class BoardDto 
{
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private String boardContent;
	private long boardRead;
	private long boardLike;
	private int boardReply;
	private String boardNotice = "N";
	
	private int boardGroup;
	private Integer boardOrigin;
	private int boardDepth;
	
	public boolean nextDay() 
	{
		LocalDateTime wtime = boardWtime.toLocalDateTime();	
		LocalDateTime now = LocalDateTime.now();
		Duration d = Duration.between(wtime, now);
		return d.toDays() >= 1;
	}
	
	public String getFormattedWtime() {
	    LocalDateTime wtime = boardWtime.toLocalDateTime();
	    LocalDateTime now = LocalDateTime.now();

	    DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm");
	    DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    if (wtime.toLocalDate().isEqual(now.toLocalDate())) {
	        return wtime.format(timeFmt); // 오늘이면 시:분
	    } else {
	        return wtime.format(dateFmt); // 그 외엔 월-일
	    }
	}
}
