package c250805api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

;

public class Test06내가만든클래스입력 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
    	File file = new File("files", "student.txt");
		FileInputStream stream = new FileInputStream(file); // 출력통로
		BufferedInputStream buffer = new BufferedInputStream(stream); // 임시저장
		ObjectInputStream object = new ObjectInputStream(buffer); // 분해도구
		
		Student s = (Student)object.readObject();
		object.close();		
    
		System.out.println(s.getName());
		System.out.println(s.getScore());
    }
}