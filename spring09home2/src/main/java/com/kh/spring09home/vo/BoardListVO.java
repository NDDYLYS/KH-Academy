package com.kh.spring09home.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardListVO 
{
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private long boardRead;
	private long boardLike;
	private int boardReply;
	private String boardNotice = "N";
	
	private int boardGroup;
	private Integer boardOrigin;
	private int boardDepth;
	
	private String memberId;
	private String memberNickname;
	private String memberLevel;
}
