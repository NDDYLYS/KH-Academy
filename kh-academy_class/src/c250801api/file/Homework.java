package c250801api.file;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

;

public class Homework 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	try 
    	{
    		while(true) 
    		{
    			String path = sc.nextLine();
    			File file = new File(path);
    			
    			if (file.exists()) 
    			{
    				if (file.isFile()) 
    				{
    					// 파일
    					System.out.println("경로 : " + file.getAbsolutePath());
    					System.out.println("파일명 : " + file.getName());
    					System.out.println("파일 크기 : " + file.length() / 1024 + "KB");
    					Date date = new Date(file.lastModified());
    					System.out.println("최종 수정 시각 : " + date);
    				}
    				else if (file.isDirectory()) 
    				{
    					// 디렉터리
    					System.out.println("경로 : " + file.getAbsolutePath());
    					File[] files = file.listFiles();
    					System.out.println("파일 개수 : " + files.length);
    					for(int i = 0; i < files.length; i++)
    					{
    						boolean temp_file = files[i].isFile();
    						System.out.println(files[i].getName() + " [" + ((temp_file) ? "파일" : "디렉터리") + "]");
    					}
    				}
    			}
    			else 
    			{
    				System.out.println("경로 : " + file.getAbsolutePath());
    				System.out.println("존재하지 않는 경로입니다.");
    			}
    		}
    		
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    	
    	sc.close();
    }
}