package c250804api.file.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

;

public class Test04바이트배열출력 
{
    public static void main(String[] args) throws IOException 
    {
    	// 여러 개의 바이트를 한 번에 출력
    	File target = new File("files", "single2.tct");
    	FileOutputStream stream = new FileOutputStream(target);
    	
    	byte[] datas = new byte[] {'A', 'B', 'C', 'D'};
    	stream.write(datas); // datas에 존재하는 모든 값을 한 번에 출력 
    	stream.write(datas, 6, 4);
    	
    	stream.close();
    }
}