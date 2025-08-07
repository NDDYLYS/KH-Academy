package c250804.api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01멀티바이트출력 
{
    public static void main(String[] args) throws IOException 
    {
    	// 멀티바이트 출력
    	// 원시형 데이터처럼 규격이 정해진 데이터들을 의미
    	
    	File target = new File("files", "nulti.txt");
    	FileOutputStream stream = new FileOutputStream(target); // 출력통로
    	BufferedOutputStream buffer = new BufferedOutputStream(stream, 10); // 임시저장
    	DataOutputStream data = new DataOutputStream(buffer); // 분해도구
    	
    	data.writeInt(100); // data를 이용해서 100을 int(4byte) 형태로 분해하여 출력
    	data.writeLong(100); // data를 이용해서 100을 long(8byte) 형태로 분해하여 출력
    	data.writeFloat(100); // data를 이용해서 100을 float(4byte) 형태로 분해하여 출력 
    	data.writeDouble(100); // data를 이용해서 100을 double(8byte) 형태로 분해하여 출력
    	data.writeChar(100); // data를 이용해서 100을 char(2byte) 형태로 분해하여 출력
    	
    	// 버퍼가 생기고 나서는 버퍼에 남아있는 데이터를 효율상관없이 내보내야 함
    	// data.flush(); // 내보내기
    	data.close(); // 내보내고 연결 종료
    	
    }
}