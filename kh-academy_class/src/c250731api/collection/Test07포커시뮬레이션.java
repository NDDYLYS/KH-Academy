package c250731api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

;

public class Test07포커시뮬레이션 
{
    public static void main(String[] args) 
    {
    	List<String> kinds = new ArrayList<>();
    	kinds.add("◇");
    	kinds.add("♡");
    	kinds.add("♣");
    	kinds.add("♠");
    	
    	List<String> numbers  = new ArrayList<>();
    	numbers.add("A");
    	numbers.add("2");
    	numbers.add("3");
    	numbers.add("4");
    	numbers.add("5");
    	numbers.add("6");
    	numbers.add("7");
    	numbers.add("8");
    	numbers.add("9");
    	numbers.add("10");
    	numbers.add("J");
    	numbers.add("Q");
    	numbers.add("K");
    	
    	List<String> allCards  = new ArrayList<>();
    	for(int k = 0; k < kinds.size(); k++) 
    	{
    		for(int n = 0; n < numbers.size(); n++) 
        	{
    			allCards.add(kinds.get(k) + "." + numbers.get(n));
        	}
    	}
    	
    	Collections.shuffle(allCards);
//    	for(int c = 0; c < allCards.size(); c++) 
//    	{
//    		System.out.print(allCards.get(c) + ", ");
//    	}
    	
    	int cardCount = 6;
    	
    	List<String> player1  = new ArrayList<>();
    	List<String> player2  = new ArrayList<>();
    	List<String> player3  = new ArrayList<>();
    	List<String> player4  = new ArrayList<>();
    	
    	for(int c = 0; c < cardCount; c++) 
    	{
    		player1.add(allCards.get((c * 4) + 0));
    		player2.add(allCards.get((c * 4) + 1));
    		player3.add(allCards.get((c * 4) + 2));
    		player4.add(allCards.get((c * 4) + 3));
    	}
    	
    	StringJoiner sj1 = new StringJoiner(",", "(", ")");
    	System.out.print("Player1 : ");
    	for(int i = 0; i < player1.size(); i++) 
    	{
    		sj1.add(player1.get(i));
    	}
    	System.out.println(sj1.toString());
    	
    	StringJoiner sj2 = new StringJoiner(",", "(", ")");
    	System.out.print("Player2 : ");
    	for(int i = 0; i < player2.size(); i++) 
    	{
    		sj2.add(player2.get(i));
    	}
    	System.out.println(sj2.toString());
    	
    	StringJoiner sj3 = new StringJoiner(",", "(", ")");
    	System.out.print("Player3 : ");
    	for(int i = 0; i < player3.size(); i++) 
    	{
    		sj3.add(player3.get(i));
    	}
    	System.out.println(sj3.toString());
    			
    	StringJoiner sj4 = new StringJoiner(",", "(", ")");
    	System.out.print("Player4 : ");
    	for(int i = 0; i < player4.size(); i++) 
    	{
    		sj4.add(player4.get(i));
    	}
    	System.out.println(sj4.toString());
    }
}