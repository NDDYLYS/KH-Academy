package c250804.api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test04로또번호열기 
{
    public static void main(String[] args) throws IOException 
    {
    	File file = new File("files", "lotto.kh");
    	FileInputStream stream = new FileInputStream(file); // 출력통로
    	BufferedInputStream buffer = new BufferedInputStream(stream); // 임시저장
    	DataInputStream data = new DataInputStream(buffer); // 분해도구
    	
    	// 프로그램 < data < buffer < stream < target < multi.txt
    	// data에게 읽고자 하는 데이터타입과 관련된 입력 명령을 실행시키도록 지시
    	int num = data.readInt();
    	System.out.println("num = " + num);
    	for(int i = 0; i < num; i++) 
    	{
    		int lotto = data.readInt();
    		System.out.println("lotto = " + lotto);
    	}
    	
    	
    	data.close();
    }
}