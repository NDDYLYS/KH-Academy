package c250804api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

;

public class Test02싱글바이트입력 
{
    public static void main(String[] args) throws IOException 
    {
    	File target = new File("files", "single.txt");
    	FileInputStream stream = new FileInputStream(target);
    	while(true) 
    	{
    		int a = stream.read();
        	System.out.println(a);
        	
        	if (a < 0)
        		break;
    	}
    	
    	stream.close();
    }
}