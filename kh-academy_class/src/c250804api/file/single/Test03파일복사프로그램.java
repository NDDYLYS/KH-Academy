package c250804api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test03파일복사프로그램 
{
    public static void main(String[] args) throws IOException 
    {
    	File file = new File("D:/dummy.txt");
    	
    	if (file.exists()) 
		{
    		System.out.println("경로 : " + file.getAbsolutePath());
    		System.out.println("파일 크기 : " + file.length() / 1024 + "KB");
    		
    		if(!file.isFile()) 
    		{
    			System.out.println("읽을 수 없습니다.");
    			System.exit(0);
    		}
    		
    		FileInputStream input = new FileInputStream(file);
    		
        	
        	input.close();
    		
    		File file2 = new File("D:/copy.txt");    		
    		FileOutputStream output = new FileOutputStream(file2);
    		
    		while(true) 
    		{
    			int a = input.read();       
    			System.out.print((char)a);
    			if (a < 0)
    				break;        			            	
    			output.write(a);
    		}

    		output.close();
		} 
    	else 
		{
			System.out.println("파일이 존재하지 않습니다.");
		}
    }
}