package com.kh.spring09home.dto;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class BoardDto 
{
	private long boardNo;
	private String boardTitle;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private String boardContent;
	private long boardRead;
	private long boardLike;
	private int boardReply;
	private String boardNotice;
}
