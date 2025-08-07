package c250801api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

;

public class Test03인기투표 
{
    public static void main(String[] args) 
    {
    	Scanner sc =  new Scanner(System.in);
    	Map<String, Integer> popularity = new HashMap<>();
    	
    	try 
    	{  		
    		while(true) 
    		{
    			System.out.print("인기투표 이름 입력 : ");
    			String vote = sc.nextLine();
    			if (vote.equals("종료")) 
    			{
    				System.out.println("투표 프로그램을 종료합니다.");
    				break;
    			}
    			
    			if (popularity.containsKey(vote)) 
    			{
    				// 아이디가 있음
    				Integer qtt = popularity.get(vote);
    				qtt++;
    				popularity.put(vote, qtt);
    				System.out.println("[" + vote + "] " + qtt + "표 획득!"); 
    			}
    			else 
    			{
    				// 새로 투표한 상대
    				popularity.put(vote, 1);
    				System.out.println("[" + vote + "] 1표 획득!"); 
    			}
    		}
    		
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    	
    	sc.close();
    	for (String key : popularity.keySet()) {
    	    System.out.println("투표 결과 = " + key + " : " + popularity.get(key) + "표");
    	}
    }
}