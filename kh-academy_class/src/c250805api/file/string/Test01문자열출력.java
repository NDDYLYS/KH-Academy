package c250805api.file.string;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

;

public class Test01문자열출력 
{
    public static void main(String[] args) throws IOException 
    {
    	// 문자열은 byte로 구성되어 있으며 자유롭게 변환 가능
    	// 싱글 바이트로 출력이 가능
    	
    	File target = new File("files", "string250805.txt");
    	FileOutputStream stream = new FileOutputStream(target);
    	
    	String str = "반갑다";
    	byte[] data = str.getBytes();
    	
    	// stream.write("환영합니다".getBytes("UTF-8"));
    	stream.write(data);
    	// Writer - FileWriter / BufferedWriter / PrintWriter
    	
    	stream.close();
    }
}