package c250805api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

;

public class Test05내가만든클래스출력 
{
    public static void main(String[] args) throws IOException 
    {
    	Student s = new Student("asasdd", 11111);
    	
    	File file = new File("files", "student.txt");
		FileOutputStream stream = new FileOutputStream(file); // 출력통로
		BufferedOutputStream buffer = new BufferedOutputStream(stream); // 임시저장
		ObjectOutputStream object = new ObjectOutputStream(buffer); // 분해도구
		
		object.writeObject(s);
		object.close();		
    }
}