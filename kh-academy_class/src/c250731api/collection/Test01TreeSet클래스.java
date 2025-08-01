package c250731api.collection;

import java.util.Set;
import java.util.TreeSet;

public class Test01TreeSet클래스 
{
    public static void main(String[] args) 
    {
    	Set<Integer> set = new TreeSet<>(); // TreeSet -> HashSet
    	
    	// 데이터 추가
    	set.add((3));
    	
    	set.size();
    	
    	set.contains(3);
    	
    	set.remove(3);
    	
    	// 데이터 추출 (구조상 한 개는 꺼낼 수 없고 전체만 꺼낼 수 있다)
    	for(int number : set) 
    	{
    	}
    }
}