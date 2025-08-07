package c250805api.file.string;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test03텍스트버전메모장만들기 
{
    public static void main(String[] args) throws IOException 
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("저장할 파일 이름을 입력해주세요 : ");
    	String fileName = sc.nextLine();
    	
    	File target = new File("files", "250805 " + fileName + ".txt");
    	FileWriter fw = new FileWriter(target);
    	BufferedWriter bw = new BufferedWriter(fw, 8192);
    	PrintWriter pw = new PrintWriter(bw);
    	
    	StringBuffer bf = new StringBuffer();
    	File temp = new File("files", "temp.txt"); 
    	//FileWriter fw = new FileWriter(target);
    	//BufferedWriter bw = new BufferedWriter(fw, 8192);
    	//PrintWriter pw = new PrintWriter(bw);
    	
    	while(true) 
    	{
    		String input = sc.nextLine();
    		if (input.equals("종료"))
    			break;
    		if (input.contains("종료"))
    			input = input.replace("종료", "");	
    		//pw.println(input);
    		//pw.flush();// 종료 없이 버퍼 비우기
    		
    		bf.append(input);
    		bf.append("\n");
    		
    	}
    	
    	pw.print(bf.toString());
    	    	
    	System.out.println("메모장을 종료합니다.");
    	sc.close();
    	pw.close();
    	
    	File temp2 = new File("files", "temp.txt"); 
    	FileInputStream is = new FileInputStream(temp2);
    	BufferedInputStream buffer = new BufferedInputStream(is);
    	FileOutputStream os = new FileOutputStream(temp2);
    	
    	byte[] data = buffer.readAllBytes();
    	os.write(data);
    	
    	buffer.close();
    	os.close();
    	
    	File dir = new File("files");
    	File tempFile = File.createTempFile("[temp", "temp]", dir);
    	tempFile.delete();
    }
}