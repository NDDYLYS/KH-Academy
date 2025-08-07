package c250805api.file.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

;

public class Test02Write사용법 
{
    public static void main(String[] args) throws IOException 
    {
    	
    	// 자동 엔터 추가 및 다양한 데이터의 문자열 출력을 위한 도구
    	
    	// 성능 제어를 위해 버퍼를 수동으로 생성하여 조합
    	
    	File target = new File("files", "string2.txt");
    	FileWriter fw = new FileWriter(target);
    	BufferedWriter bw = new BufferedWriter(fw, 8192);
    	PrintWriter pw = new PrintWriter(bw);
    	
    	pw.println("안녕, 반갑다");//fw.write("안녕, 반갑다");
    	pw.println(500087);//fw.write("\n");
      	//fw.write(77777);
    	//숫자는 출력이 안 된다
    	//버퍼가 없어서 성능이 안 좋다
    	
    	pw.close();
    }
}