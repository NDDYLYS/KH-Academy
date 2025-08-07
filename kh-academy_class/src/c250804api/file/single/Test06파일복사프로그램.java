package c250804api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test06파일복사프로그램 
{
    public static void main(String[] args) throws IOException 
    {
    	long start = System.currentTimeMillis();
    	Scanner sc = new Scanner(System.in);
    	System.out.print("한 번에 옮길 배열의 크기를 선언하세요 : ");
    	int bytes = sc.nextInt();
    	
    	File file = new File("D:/dummy.zip");
    	
    	if (file.exists()) 
		{
    		System.out.println("경로 : " + file.getAbsolutePath());
    		System.out.println("파일 크기 : " + file.length() / (1024 * 1024) + "MB");
    		
    		if(!file.isFile()) 
    		{
    			System.out.println("읽을 수 없습니다.");
    			System.exit(0);
    		}
    		
    		File file2 = new File("D:/copy.zip");    		
    		FileInputStream input = new FileInputStream(file);
    		FileOutputStream output = new FileOutputStream(file2);
    		
    		byte[] buffer = new byte[bytes];
    		
    		while(true) 
    		{
    			int a = input.read(buffer);
    			if (a < 0)
    				break;        			            	
    			output.write(buffer, 0, a);
    		}
    		
    		long end = System.currentTimeMillis();
    		System.out.println("복사가 완료되었습니다.");
    		System.out.println((float)(end - start) / 1000f + "초");
    		
    		
    		input.close();
    		output.close();
		} 
    	else 
		{
			System.out.println("파일이 존재하지 않습니다.");
		}
    }
}