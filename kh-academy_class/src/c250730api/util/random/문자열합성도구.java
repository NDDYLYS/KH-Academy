package c250730api.util.random;

import java.util.Arrays;
import java.util.StringJoiner;

public class 문자열합성도구 
{
    public static void main(String[] args) 
    {
    	String[] fruits = new String[]{"바나나", "딸기", "포도", "수박", "키위"};
    	
    	StringJoiner sj = new StringJoiner(",", "[", "]"); // 쉼표와 공백을 구분자로 설정

    	for(int i = 0; i < fruits.length; i++) 
    	{
    		sj.add(fruits[i]);
    	}

        System.out.println(sj.toString());
        
        System.out.println(Arrays.toString(fruits));
    }
}