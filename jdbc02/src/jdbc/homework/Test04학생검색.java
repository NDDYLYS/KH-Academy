package jdbc.homework;

import java.util.List;
import java.util.Scanner;

import jdbc.dao.StudentDao;
import jdbc.dto.StudentDto;

public class Test04학생검색 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
	    System.out.print("검색할 학생의 이름을 입력해주세요 : ");	
    	String studentName = sc.nextLine();
    	
    	StudentDao studentDao = new StudentDao();
    	StudentDto element = studentDao.selectSolo(studentName);
    	
    	System.out.println("조회 결과 : 1개");
    	System.out.println(element);
    }
}