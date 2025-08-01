package c250801api.collection2;

import java.util.Set;
import java.util.TreeSet;

;

public class Test04집합연산 
{
    public static void main(String[] args) 
    {
    	// Set을 이용해서 합집합, 교집합, 차집합 등을 구할 수 있다
    	Set<String> a = Set.of("apple", "strawberry", "watermelon", "peach");
    	Set<String> b = Set.of("peach", "grape", "watermelon", "banana");
    	
    	// 합집합
    	Set<String> union = new TreeSet<>();
    	union.addAll(a);
    	union.addAll(b);
    	
    	// 교집합
    	Set<String> intersection = new TreeSet<>();
    	intersection.addAll(a);
    	intersection.retainAll(b);
    	// 중복되는 애들만 남긴다
    	
    	// 차집합
    	Set<String> minus1 = new TreeSet<>();
    	minus1.addAll(a);
    	minus1.removeAll(b); // b와 겹치는 내용을 제거
    	// a - b
    	
    	// 차집합
    	Set<String> minus2 = new TreeSet<>();
    	minus2.addAll(b);
    	minus2.removeAll(a); // a와 겹치는 내용을 제거
    	// b - a
    }
}