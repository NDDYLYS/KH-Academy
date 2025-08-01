package c250801api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test01Map클래스 
{
    public static void main(String[] args) 
    {
    	// collection<E> 가변 데이터를 저장하기 위한 저장소
    	// List<E>		순서가 필요한 데이터를 저장하기 위한 저장소
    	// Set<E> 		정해진 원리에 따라 저장되는 검색에 최적화된 데이터 저장소
    	// Map<K, V>	Key-Value 형태로 데이터를 관리하는 저장소
    	//				개별 제어에 가장 빠르다
    	
    	Map<String, Integer> languages = new HashMap<>();
    	
    	languages.put("C", 1972);
    	languages.put("C++", 1983);
    	languages.put("Java", 1995);
    	languages.put("PHP", 1995);
    	languages.put("Python", 1991);
    	// 중복된 키를 삽입시 값이 변한다
    	// null이 나올 수 있으므로 Integer를 사용할 것
    	// 키와 밸류가 따로 있다
    }
}