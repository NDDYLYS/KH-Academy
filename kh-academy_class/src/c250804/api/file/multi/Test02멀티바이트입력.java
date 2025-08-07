package c250804.api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Test02멀티바이트입력 
{
    public static void main(String[] args) throws IOException 
    {
    	File target = new File("files", "multi.txt");
    	FileInputStream stream = new FileInputStream(target); // 출력통로
    	BufferedInputStream buffer = new BufferedInputStream(stream, 10); // 임시저장
    	DataInputStream data = new DataInputStream(buffer); // 분해도구
    	
    	// 프로그램 < data < buffer < stream < target < multi.txt
    	// data에게 읽고자 하는 데이터타입과 관련된 입력 명령을 실행시키도록 지시
    	int a = data.readInt();
    	long b = data.readLong();
    	float c = data.readFloat();
    	double d = data.readDouble();
    	char e = data.readChar();
    	
    	data.close();
    	
    	System.out.println("a = " + a);
    	System.out.println("b = " + b);
    	System.out.println("c = " + c);
    	System.out.println("d = " + d);
    	System.out.println("e = " + e);
    }
}