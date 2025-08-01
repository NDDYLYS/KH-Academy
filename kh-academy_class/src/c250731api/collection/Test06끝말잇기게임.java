package c250731api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

;

public class Test06끝말잇기게임 
{
    public static void main(String[] args) 
    {
    	List<String> words = new ArrayList<>();
    	
    	try 
    	{
    		Scanner sc = new Scanner(System.in);
    		List<String> suggests = new ArrayList<>();
    		suggests.add("사과");
    		suggests.add("바나나");
    		suggests.add("자동차");
    		suggests.add("기차");
    		suggests.add("학교");
    		suggests.add("모자");
    		suggests.add("고양이");
    		suggests.add("냉장고");
    		suggests.add("컴퓨터"); 
    		suggests.add("달력");
    		
    		Collections.shuffle(suggests);
    		System.out.println("제시어 : " + suggests.get(0));
    		String suggest = suggests.get(0);
    		
    		while(true) 
    		{
    			String input = sc.nextLine();
    			if (input.length() < 2 || input.contains(" "))
    				throw new Exception("입력하신 글자가 2글자 이하이거나 공백이 포함되어 있습니다.");    			
    			
    			if (!WordConnection(suggest, input)) 
    				throw new Exception("두 단어가 서로 연결되지 않습니다.");
    			    			
    			if (words.contains(input)) 
    				throw new Exception("이미 입력하신 단어입니다.");
   
    			words.add(input);
    			suggest = input;
    			
    			System.out.println(input + "!");
    		}
    		
    		//throw new Exception("Error");
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    	
    	StringJoiner sj = new StringJoiner(",", "[", "]");
    	for(int i = 0; i < words.size(); i++) 
    	{
    		sj.add(words.get(i));
    	}

    	System.out.println("게임 종료! 지금까지 적은 단어의 숫자 : " + words.size());
        System.out.println(sj.toString());
    }
    
    public static boolean WordConnection(String first, String second) 
    {
    	boolean connect = false;
    	
    	String first0 = first.substring(first.length() - 1);
    	// char last = first.charAt(first.length() - 1);
    	// char first = second.charAt(0);
    	String second9 = second.substring(0, 1);
    	if (first0.equals(second9))
    		connect = true;    	
    	return connect;
    }
}