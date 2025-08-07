package c250731api.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01저장소별차이 
{
    public static void main(String[] args) 
    {
    	// ArrayList vs TreeSet
    	ArrayList<String> a = new ArrayList<String>(); // 순서가 보장
    	TreeSet<String> b = new TreeSet<String>(); // 오름차순 / 내림차순 정렬
    	
    	a.add("피카츄");
    	b.add("피카츄");
    	
    	a.add("야도란");
    	b.add("야도란");
    	
    	a.add("또도가스");
    	b.add("또도가스");
    	
    	a.add("가가멜");
    	b.add("가가멜");
    	
    	System.out.println("a = " + a);
    	System.out.println("b = " + b);
    }
}