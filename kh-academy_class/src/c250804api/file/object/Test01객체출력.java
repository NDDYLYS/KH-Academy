package c250804api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Date;

public class Test01객체출력 
{
    public static void main(String[] args) throws IOException 
    {
    	File target = new File("files", "object.txt");
    	FileOutputStream stream = new FileOutputStream(target); // 출력통로
    	BufferedOutputStream buffer = new BufferedOutputStream(stream); // 임시저장
    	ObjectOutputStream object = new ObjectOutputStream(buffer); // 분해도구
    	
    	Date d = new Date();
    	object.writeObject(d);
    	
    	LocalDateTime current = LocalDateTime.now();
    	object.writeObject(current);
    	
    	object.close();
    }
}