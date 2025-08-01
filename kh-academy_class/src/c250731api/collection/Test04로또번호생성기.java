package c250731api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Test04로또번호생성기 
{
    public static void main(String[] args) 
    {
    	List<Integer>  	lottos = new ArrayList<>();
    	
    	for(int i = 0; i < 45; i++)
    	{
    		lottos.add(i + 1);
    	}
    	
     	Collections.shuffle(lottos);
    	
    	GetPrint(lottos);
    }
    
    public static void GetPrint(List<Integer> _list) 
    {
    	List<Integer> returnList = _list;
    	StringJoiner sj = new StringJoiner(",", "[", "]");
    	for(int i = 0; i < 6; i++) 
    	{
    		sj.add(returnList.get(i).toString());
    	}
    	
    	System.out.println(sj.toString());
    }
}