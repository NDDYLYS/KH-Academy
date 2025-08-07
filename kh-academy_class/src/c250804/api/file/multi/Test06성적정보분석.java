package c250804.api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

;

public class Test06성적정보분석 
{
    public static void main(String[] args) 
    {

    	try 
    	{
    		Scanner sc = new Scanner(System.in);
    		System.out.print("내 시험점수를 입력해주세요 : ");
    		int myScore = sc.nextInt(); 
    		
    		File file = new File("files", "scores.db");
        	FileInputStream stream = new FileInputStream(file); // 출력통로
        	BufferedInputStream buffer = new BufferedInputStream(stream); // 임시저장
        	DataInputStream data = new DataInputStream(buffer); // 분해도구
        	
        	// 프로그램 < data < buffer < stream < target < multi.txt
        	// data에게 읽고자 하는 데이터타입과 관련된 입력 명령을 실행시키도록 지시
        	List<Integer> scores = new ArrayList<>();
        	scores.add(myScore);
        	
        	for(int i = 0; i < 10; i++) 
        	{
        		scores.add(data.readInt());
        	}
        	scores.sort(Comparator.reverseOrder());

        	
//        	for(int score : scores) 
//        	{
//        		System.out.print(score + "/");
//        	}
        	
        	int ranking = scores.indexOf(myScore) + 1;
     		System.out.println("내 시험점수는 " + ranking + "등입니다.");
     		
        	data.close();
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    }
}