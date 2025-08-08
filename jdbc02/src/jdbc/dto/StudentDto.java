package jdbc.dto;

import java.sql.Timestamp;

public class StudentDto 
{
	private int studentNo;
	private String studentName;
	private int studentKor;
	private int studentEng;
	private int studentMat;
	private Timestamp studentReg;
	
	public Timestamp getStudentReg() {
		return studentReg;
	}

	public void setStudentReg(Timestamp studentReg) {
		this.studentReg = studentReg;
	}

	public StudentDto() 
	{
		
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentKor() {
		return studentKor;
	}

	public void setStudentKor(int studentKor) {
		this.studentKor = studentKor;
	}

	public int getStudentEng() {
		return studentEng;
	}

	public void setStudentEng(int studentEng) {
		this.studentEng = studentEng;
	}

	public int getStudentMat() {
		return studentMat;
	}

	public void setStudentMat(int studentMat) {
		this.studentMat = studentMat;
	}

	@Override
	public String toString() {
		return "StudentDao [studentNo=" + studentNo + ", studentName=" + studentName + ", studentKor=" + studentKor
				+ ", studentEng=" + studentEng + ", studentMat=" + studentMat + "]";
	}
}