package c250731api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test05사다리게임 
{
    public static void main(String[] args) 
    {
    	try 
    	{
    		Scanner sc = new Scanner(System.in);
        	System.out.println("사다리 게임을 몇 명이서 하시겠습니까? (최소 3명, 최대 99명)");
        	int min = 3;
        	int max = 99;
        	
        	int memberCount = sc.nextInt();
        	
        	if(memberCount < min)
        		throw new Exception("인원이 최소값보다 적습니다.");        	
        	if(max < memberCount)
            	throw new Exception("인원이 최대값보다 많습니다.");
        	
        	List<String> memberNames = new ArrayList<>();
        	List<String> commands = new ArrayList<>();
        	sc.nextLine();
        	
        	for(int c = 0; c < memberCount; c++) 
        	{
        	 	System.out.print((c + 1) + "번쨰 유저의 이름을 입력해주세요 : ");
        	 	String name = sc.nextLine();
        	 	if (!memberNames.contains(name))
        	 		memberNames.add(name);
        	 	else 
        	 	{
        	 		c--;
        	 		throw new Exception("같은 이름을 지닌 사람이 이미 있습니다.");
        	 	}
        	}
        	
        	for(int c = 0; c < memberCount; c++) 
        	{
        		System.out.print("걸린 유저가 할 벌칙을 정해주세요 : ");
        		String command = sc.nextLine();
        		
        		commands.add(command);
        	}
        	Collections.shuffle(commands);
        	
        	System.out.println("벌칙 추첨!");
         	for(int c = 0; c < memberCount; c++) 
        	{
         		System.out.println((c + 1) + "번째 유저[" + memberNames.get(c) + "]가 걸린 벌칙 : " + commands.get(c));
        	}
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    }
}