package c250801api.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Homework 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	try 
    	{
    		String allPath = System.getProperty("user.home");
    		File temp_file = new File(allPath);
    		// File current = new File("C:/");
    		// File target = new File(allPath, addPath);
    		PrintFileList(temp_file);
    		
    		while(true) 
    		{    			
    			String addPath = sc.nextLine();
    		
    			if (addPath.equals("/")) 
    			{
    				allPath = System.getProperty("user.home");
    				// File[] drives = File.listRoot();
    			}
    			else if (addPath.equals("../")) 
    			{
    				allPath = GoParentDirectory(allPath);
    				// File file = current.getParentFile();
    			}
    			else 
    			{
    				allPath += "\\" + addPath;
    			}
    			
    			File file = new File(allPath);
    			
    			boolean exit = PrintFileList(file);
    			if (!exit)
    				break;
    		}
    		
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    	
    	sc.close();
    }
    
    public static boolean PrintFileList(File file) 
    {
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
				Format f = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
				System.out.println("최종 수정 시각 : " + f.format(date));
			}
			else if (file.isDirectory()) 
			{
				// 디렉터리
				System.out.println("경로 : " + file.getAbsolutePath());
				File[] files = file.listFiles();
				int hidden = 0;
				for(File temp : files) 
				{
					if (!temp.isHidden())
						hidden ++;
				}
				System.out.println("파일 개수 : " + hidden);
				for(int i = 0; i < files.length; i++)
				{
					if (files[i].isHidden())
						continue;
					boolean temp_file = files[i].isFile();
					System.out.println(files[i].getName() + " [" + ((temp_file) ? "파일" : "디렉터리") + "]");
				}
			}
		}
		else 
		{
			System.out.println("경로 : " + file.getAbsolutePath());
			System.out.println("존재하지 않는 경로입니다.");
			return false;
		}
    	
    	return true;
    }
    
    public static String GoParentDirectory(String allPath) 
    {
        char target = '\\';

        int lastChar = allPath.lastIndexOf(target);
        if (lastChar != -1)
            return allPath.substring(0, lastChar);
        return "";
    }
}
