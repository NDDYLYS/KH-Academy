package jdbc.homework;

import java.util.List;

import jdbc.dao.StudentDao;
import jdbc.dto.StudentDto;

public class Test02학생조회 
{
    public static void main(String[] args) 
    {
    	StudentDao studentDao = new StudentDao();
    	List<StudentDto> list = studentDao.selectList();
    	
    	System.out.println("조회 결과 : " + list.size() + "개");
    	for (StudentDto studentDto : list) 
    	{
    		System.out.println(studentDto);
    	}
    }
}