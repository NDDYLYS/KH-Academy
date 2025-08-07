package c250804api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MemberUtils 
{
	private Map<String, String> map = new HashMap<>();
	
	public void Load() 	
	{
		try
		{
			File file = new File("files", "member.txt");
        	FileInputStream stream = new FileInputStream(file); // 출력통로
        	BufferedInputStream buffer = new BufferedInputStream(stream); // 임시저장
        	ObjectInputStream object = new ObjectInputStream(buffer); // 분해도구
        	
        	map = (Map<String, String>)object.readObject();
        	object.close();
		}
		catch(Exception e) 
		{
			map = new HashMap<>();
		}
	}
	
	public boolean Save() 
	{
		try 
		{
			File file = new File("files", "member.txt");
			FileOutputStream stream = new FileOutputStream(file); // 출력통로
			BufferedOutputStream buffer = new BufferedOutputStream(stream); // 임시저장
			ObjectOutputStream object = new ObjectOutputStream(buffer); // 분해도구
			
			object.writeObject(map);
			object.close();			
			return true;
		} 
		catch (Exception e) 
		{
			
		}
		return false;
	}
	
	public void AddUser(String id, String pwd) 
	{
		if (!map.containsKey(id.toLowerCase()))
			map.put(id.toLowerCase(), pwd);
	}
	
	public boolean Login(String id, String pwd)
	{
		if (map.containsKey(id.toLowerCase())) 
		{
			String password = map.get(id.toLowerCase());
			if (pwd.equals(password)) 
			{		
				return true;
			}
		}      		
		return false;
	}
	
	public boolean CheckId(String id) 
	{
		return map.containsKey(id.toLowerCase());
	}
}