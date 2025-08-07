package c250801api.file;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Test01파일제어 
{
    public static void main(String[] args) 
    {
    	// FS File System
    	// 파일들이 모인 징서 :
    	// 디렉토리
    	
    	String input = "abc/def/ghi";
        char target = '/';

        int lastIndex = input.lastIndexOf(target);

        if (lastIndex != -1) {
            String result = input.substring(0, lastIndex);
            System.out.println(result); // 출력: abc/def
        } else {
            System.out.println(input); // 해당 문자가 없을 경우 원본 출력
        }
    	
    	
    	
    	// File f = new File("./files/c250801File.txt");
    	File f = new File(System.getProperty("user.home"), "sample.txt");
    	// System.getProperty("user.home") : 내 컴퓨터/C드라이브/사용자/user1
    	// f.exists(); // true
    	
    	if (!f.exists()) 
    	{
    		// 파일이 존재하지 않습니다.
    		// System.exit(0);
    	}
    	
    	System.out.println("존재 : " + f.exists());
    	System.out.println("이름 : " + f.getName());
    	System.out.println("크기 : " + f.length() + "bytes");
    	System.out.println("경로 : " + f.getPath());
    	System.out.println("수정한 날짜 : " + f.lastModified());
    	// Date d = new Date(f.lastModified());
    	// SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E H시 m분 s초");
    	System.out.println("읽기전용 : " + !f.canWrite());
    	System.out.println("숨김상태 : " + f.isHidden());
    	
//    	 Path path = Paths.get("example.txt");
//    	 List<String> lines = Files.readAllLines(path);
//
//         for (String line : lines) {
//             System.out.println(line);
//         }
    	
    	// f.delete();    	
    	// 프로그램을 기준으로 경로를 계산하여 처리
    	// user Folder
    }
    
    public static String GoParentDirectory(String allPath) 
    {
    	String[] splits = allPath.split("\\");
    	
    	return "";
    }
}