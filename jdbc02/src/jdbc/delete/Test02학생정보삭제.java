package jdbc.delete;

import jdbc.dao.StudentDao;

public class Test02학생정보삭제 
{
    public static void main(String[] args) 
    {
    	int studentNo = 2;
    	
    	StudentDao studentDao = new StudentDao();
    	boolean success = studentDao.delete(studentNo);
    	if (success)
    		System.out.println("삭제 완료");
    	else 
    		System.out.println("삭제 실패");
    }
}