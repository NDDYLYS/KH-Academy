package com.kh.spring09home.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AttachmentDto 
{
	private int attachmentNo;
	private String attachmentName;
	private String attachmentType;
	private long attachmentSize;
	private Timestamp attachmentTime;
}
