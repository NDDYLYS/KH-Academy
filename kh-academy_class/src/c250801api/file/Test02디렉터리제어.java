package c250801api.file;

import java.io.File;
import java.util.Scanner;

;

public class Test02디렉터리제어 
{
    public static void main(String[] args) 
    {
//    	File f = new File("./files/Sample1.txt");
//    	System.out.println("존재 : " + f.exists());
    	
    	File dir = new File("files");
    	
    	if (dir.exists()) 
    	{
    		System.out.println("대상이 존재합니다.");
    		// 디렉터리의 분석의 핵심은 안에 있는 파일 혹은 디렉토리 목록
    		System.out.println("크기 : " + dir.length());
    		System.out.println("상대경로 : " + dir.getPath());
    		System.out.println("절대경로 : " + dir.getAbsolutePath());
    		
    		// .list()는 디렉터리 내부에 모든 요소들의 이름을 반환
    		for(String name : dir.list()) 
    		{
    			System.out.println("이름 : " + name);
    		}
    		
    		// .listFiles()는 디렉터리 내부에 모든 요소들을 객체로 반환
    		for(File file : dir.listFiles()) 
    		{
    			System.out.println("이름 : " + file.getName());
    			
//    			Scanner scanner = new Scanner(file);
//
//		        while (scanner.hasNextLine()) {
//		            String line = scanner.nextLine();
//		            System.out.println(line);
//		        }
    		}
    	}
    	
    }
}