package c250805api.file.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

;

public class Test04문자열입력2 
{
    public static void main(String[] args) throws IOException 
    {
    	// Reader 클래스를 이용해서 문자열을 온전하게 읽는 것이 목표
    	// FileWriter <-> FileReader
    	// BufferedWriter <-> BuffereredReader
    	// PrintWriter <-> PrintReader 없음
    	
    	File target = new File("files", "string2.txt");
    	FileReader fr = new FileReader(target);
    	BufferedReader br = new BufferedReader(fr);
    		
//    	String line = br.readLine();
//    	System.out.print("line = " + line);
//    	line = br.readLine();
//    	System.out.print("line = " + line);
//    	line = br.readLine();
//    	System.out.print("line = " + line);
//    	line = br.readLine();
//    	System.out.print("line = " + line);
//    	line = br.readLine();
//    	System.out.print("line = " + line);
//    	line = br.readLine();
//    	System.out.print("line = " + line);
    	
    	while(true) 
    	{
    		String line = br.readLine();
    		if (line == null)
    			break; //EOF
    		System.out.print("line = " + line);
    	}
    }
}