package c250721;

import java.util.Random;

public class Test11버블정렬 
{
    public static void main(String[] args) 
    {
       	Random r = new Random();
    	int[] array = new int[5];
    	
    	for(int i = 0; i < array.length; i++)
    	{
    		array[i] = r.nextInt(100);
    	}
    	
    	
    	System.out.print("Before : ");
    	for(int b = 0; b < array.length; b++)
    	{
    		System.out.print(array[b] + "/");
    	}
    	System.out.println();
    	
    	// burble sort
    	for(int c = array.length - 2; c >= 0; c--) 
    	{    		
    		for (int i = 0; i <= c; i++) 
    		{
    			//System.out.println(i + "와 " + (i + 1) + "을 비교");
    			
    			if (array[i + 1] < array[i]) 
    			{
    				int swap = array[i];
    				array[i] = array[i + 1];
    				array[i + 1] = swap;	
    			}
    		}
    	}
    	
    	/*
	 *		for(int k = array.length - 2; k >= 0; k--)
    	 * 		for(int i = 0; i <= k; i++)
    	 * 			if (array[i + 1] < array[i]) 
    				{
    					int swap = array[i];
    					array[i] = array[i + 1];
    					array[i + 1] = swap;	
    				}
    	 * */
    	
    	
    	System.out.print("After : ");
    	for(int a = 0; a < array.length; a++)
    	{
    		System.out.print(array[a] + "/");
    	}
    }
}