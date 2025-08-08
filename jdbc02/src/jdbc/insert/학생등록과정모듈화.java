package jdbc.insert;

import java.util.Scanner;

import jdbc.dao.StudentDao;
import jdbc.dto.StudentDto;

;

public class 학생등록과정모듈화 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("학생의 이름을 입력해주세요 : ");
		String studentName = sc.nextLine();
		
		System.out.print("학생의 국어점수를 입력해주세요 : ");
		int studentKor = sc.nextInt();
		
    	System.out.print("학생의 영어점수를 입력해주세요 : ");
    	int studentEng = sc.nextInt();
		
		System.out.print("학생의 수학점수를 입력해주세요 : ");
		int studentMat = sc.nextInt();
  		
		sc.close();
		StudentDto studentDto = new StudentDto();
		studentDto.setStudentName(studentName);
		studentDto.setStudentKor(studentKor);
		studentDto.setStudentEng(studentEng);
		studentDto.setStudentMat(studentMat);
		
		StudentDao studentDao = new StudentDao();
		studentDao.insert(studentDto);
		
		System.out.println("학생 " + studentDto.getStudentName() + "가 입력되었습니다.");		
    }
}