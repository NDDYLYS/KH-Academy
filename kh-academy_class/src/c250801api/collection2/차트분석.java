package c250801api.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class 차트분석 
{
    public static void main(String[] args) 
    {
    	Set<String> youtube = Set.of("Golden","Soda Pop","뛰어","시작의 아이","Your Idol");
    	Set<String> melon = Set.of("Golden","Soda Pop","뛰어","FAMOUS","Dirth Work");
    	/*
    	 *  유튜브 뮤직과 멜론 뮤직 두 군데 다 순위권인 곡을 출력하세요
			유튜브 뮤직이나 멜론 뮤직 둘 중 한 군데에서만 순위권인 곡을
    	 * */
    	
    	Set<String> intersection = new TreeSet<>();
    	intersection.addAll(youtube);
    	intersection.retainAll(melon);    	
    	System.out.println(intersection);
    	
    	Set<String> each = new HashSet<>();
    	each.addAll(youtube);
    	each.addAll(melon);
    	each.removeAll(intersection);
    	System.out.println(each);
    }
}