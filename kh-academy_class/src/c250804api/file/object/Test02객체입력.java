package c250804api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.Date;

public class Test02객체입력 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
    	// java.io.Serializablw이라는 인터페이스를 상속받아야만 출력 가능
    	File target = new File("files", "object.txt");
    	FileInputStream stream = new FileInputStream(target); // 출력통로
    	BufferedInputStream buffer = new BufferedInputStream(stream); // 임시저장
    	ObjectInputStream object = new ObjectInputStream(buffer); // 분해도구
    	
    	Date date = (Date)object.readObject();
    	LocalDateTime current = (LocalDateTime)object.readObject();
    	
    	object.close();
    	System.out.println("date" + date);
       	System.out.println("current" + current);
    }
}