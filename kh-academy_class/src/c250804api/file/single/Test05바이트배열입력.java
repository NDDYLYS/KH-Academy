package c250804api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

;

public class Test05바이트배열입력 
{
    public static void main(String[] args) throws IOException 
    {
    	// 바이트배열 입력
    	File target = new File("files", "single2.txt");
    	FileInputStream stream = new FileInputStream(target);
    	
    	byte[] buffer = new byte[10];
    	stream.read(buffer); // stream의 read 메소드 중 배열에 통째로 ㅍ\입력하는 것을 사용 
    	//int size = stream.read(buffer);
    	//System.out.print(Arrays.toString(buffer));
    	
    	while(true) 
    	{
    		int size = stream.read(buffer);
    		if (size == -1)
    			break;
    		
    		System.out.println(Arrays.toString(buffer));
    	}
    
    }
}