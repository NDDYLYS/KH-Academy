package c250804.api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

;

public class Test03로또저장프로그램 
{
    public static void main(String[] args) 
    {
    	try 
    	{
    		Scanner sc = new Scanner(System.in);
    		System.out.print("저장하고 싶은 정수의 개수 : ");
    		int num = sc.nextInt();
    		sc.close();
    		
    		Random r = new Random();
    		List<Integer> lottos = new ArrayList<>();
    		while (true) 
    		{
    			int ran = r.nextInt(45) + 1;
    			if (!lottos.contains(ran))
    				lottos.add(ran);
    			
    			if (num <= lottos.size())
    				break;
    		}
    		
    		File file = new File("files", "lotto.kh");
        	FileOutputStream stream = new FileOutputStream(file); // 출력통로
        	BufferedOutputStream buffer = new BufferedOutputStream(stream); // 임시저장
        	DataOutputStream data = new DataOutputStream(buffer); // 분해도구
        	
        	data.writeInt(num); 
        	for(Integer lotto : lottos) 
        	{
        		data.writeInt(lotto); 
        	}
        	
        	data.close();
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    }
}