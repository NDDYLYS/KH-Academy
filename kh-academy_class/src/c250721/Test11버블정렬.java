package c250721;

import java.util.Random;

public class Test11버블정렬 
{
    public static void main(String[] args) 
    {
       	Random r = new Random();
    	int[] array = new int[3];
    	
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
      	
      	for(int c = 0; c < array.length - 1; c++) 
      	{
      		for (int i = c + 1; i < array.length - 1; i++) 
      		{
      			if (array[i] < array[c]) 
          		{
          			int swap = array[c];
          			array[c] = array[i];
          			array[i] = swap;
          		}
      		}
      	}
    	
    	
    	System.out.print("After : ");
    	for(int a = 0; a < array.length; a++)
    	{
    		System.out.print(array[a] + "/");
    	}
    }
}