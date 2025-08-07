package c250804api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Test03사전처리 
{
    public static void main(String[] args) throws IOException 
    {
    	Map<String, String> members = new HashMap<>();
    	for(int i = 0; i < 200; i++) 
    	{
    		members.put("testuser" + i, "TestUser" + i + "!");
    	}
    	
    	File file = new File("files", "member.txt");
    	FileOutputStream stream = new FileOutputStream(file); // 출력통로
    	BufferedOutputStream buffer = new BufferedOutputStream(stream); // 임시저장
    	ObjectOutputStream object = new ObjectOutputStream(buffer); // 분해도구
    	
    	object.writeObject(members);
    	object.close();
    }
}