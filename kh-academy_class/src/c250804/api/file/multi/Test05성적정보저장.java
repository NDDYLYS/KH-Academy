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

public class Test05성적정보저장 
{
    public static void main(String[] args) 
    {
    	try 
    	{
    		Scanner sc = new Scanner(System.in);
    		
    		File file = new File("files", "scores.db");
        	FileOutputStream stream = new FileOutputStream(file); // 출력통로
        	BufferedOutputStream buffer = new BufferedOutputStream(stream); // 임시저장
        	DataOutputStream data = new DataOutputStream(buffer); // 분해도구
        	
        	for(int i = 0; i < 10; i++) 
        	{
        		System.out.print("시험점수를 입력하세요 : ");
        		int score = sc.nextInt();
        		data.writeInt(score);
        	}
        	
        	System.out.println("시험점수 입력이 종료되었습니다.");
        	data.close();
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    }
}