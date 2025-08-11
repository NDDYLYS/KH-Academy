package jdbc.update;

import jdbc.dao.StudentDao;
import jdbc.dto.StudentDto;

;

public class Test02학생성적수정 
{
    public static void main(String[] args) 
    {
    	StudentDto studentDto = new StudentDto();
    	studentDto.setStudentNo(3);
    	studentDto.setStudentName("수정한이름");
    	studentDto.setStudentKor(99);
    	studentDto.setStudentEng(88);
    	studentDto.setStudentMat(77);
    	
    	StudentDao studentDao = new StudentDao();
    	boolean success = studentDao.update(studentDto);
    	if (success)
    		System.out.println("수정 완료");
    	else 
    		System.out.println("수정 실패");
    }
}