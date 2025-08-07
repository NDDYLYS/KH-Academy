package c250804api.file.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01싱글바이트출력 
{
    public static void main(String[] args) 
    {
    	// FileOutputStream 저장
    	// FileInputStream 불러오기
    	
    	// 준비물 : 파일, 통로 제어용 인스턴스
    	try {
    		File file = new File(System.getProperty("user.home"), "Sample1.txt");
    	    FileOutputStream stream = new FileOutputStream(file);
    	    stream.write(40000);
    	    stream.close();
    	} catch (IOException e) {
    	    e.printStackTrace(); // 에러 출력
    	}
    }
}