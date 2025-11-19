
package com.kh.spring10.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class StudentDto 
{
	private int studentNo;
	private String studentName;
	private int studentKor;
	private int studentEng;
	private int studentMat;
	private Timestamp studentReg;
	private int studentLike;
	
	
	public double getStudentAverage() 
	{
		return getTotal() / 3d;
	}
	
	public double getTotal() 
	{
		return (getStudentKor() + getStudentEng() + getStudentMat());
	}
}
