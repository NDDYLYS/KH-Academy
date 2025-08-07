package c250731api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test02ArrayList클래스 
{
    public static void main(String[] args) 
    {	
    	// 생성
    	ArrayList a = new ArrayList(); // 제네릭 미명시
    	ArrayList<String> b = new ArrayList<String>();
    	ArrayList<String> c = new ArrayList<>();
    	List<String> d = new ArrayList<>(); // 선호
    	
    	d.add("자바");
    	d.add("파이썬");
    	d.add("C++");
    	d.add(1, "루비");
    	
    	System.out.println("d :" + d);
    	System.out.println("d의 개수 = " + d.size() );
    	
    	System.out.println("0의 위치 :" + d.get(0));
    	
    	// 데이터 검색
    	System.out.println("파이썬이 있어? " + d.contains("파이썬"));
    	
    	// 데이터 삭제
    	d.remove(1);
    	d.remove("파이썬");
    	
    	System.out.println("d :" + d);
    }
}