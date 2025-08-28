package com.kh.spring09home.dto;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

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
	private String boardNotice;
	
	public boolean nextDay() 
	{
		LocalDateTime wtime = boardWtime.toLocalDateTime();	
		LocalDateTime now = LocalDateTime.now();
		Duration d = Duration.between(wtime, now);
		return d.toDays() >= 1;
	}
}
