
package com.kh.spring09home.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto 
{
	private int studentNo;
	private String studentName;
	private int studentKor;
	private int studentEng;
	private int studentMat;//
	private Timestamp studentReg;
	
	
	public double getStudentAverage() 
	{
		return (getStudentKor() + getStudentEng() + getStudentMat()) / 3d;
	}
}
