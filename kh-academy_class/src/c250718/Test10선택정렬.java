package c250718;

import java.util.Random;

;

public class Test10선택정렬 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 	다음과 같이 데이터를 준비한 뒤 요청사항에 맞게 정렬 코드를 구현하여 데이터를 오름차순으로 정렬하여 보여주세요.
			int[] numbers = new int[]{30, 50, 20, 10, 40};
			
			정렬이란 데이터를 어떠한 기준에 따라 오름차순 또는 내림차순으로 나열하는 것을 말합니다.
			오름차순 - 작은 데이터가 먼저 나오도록 나열하는 방법
			내림차순 - 큰 데이터가 먼저 나오도록 나열하는 방법
			
			정렬에는 여러 가지 방법들이 있으며, 그 내용들은 다음 사이트에서 확인하실 수 있습니다.
			
			정렬의 종류와 특징 - https://www.toptal.com/developers/sorting-algorithms
			정렬 종류별 시뮬레이션 - https://visualgo.net/en/sorting
			
			이 중 첫 번째 방법인 선택 정렬의 규칙에 맞게 데이터를 정렬하면 됩니다.
			
			선택정렬이란, 가장 작은 값을 앞에서부터 순차적으로 배치하여 배열의 데이터를 정렬하는 방식입니다. (https://www.toptal.com/developers/sorting-algorithms/selection-sort)
			
			데이터가 5개일 경우 
			첫 번째 턴에서는 0 지점부터 4지점 중 가장 작은 값을 찾아 0지점에 있는 데이터와 교체합니다.
			두 번째 턴에서는 1 지점부터 4지점 중 가장 작은 값을 찾아 1지점에 있는 데이터와 교체합니다.
			세 번째 턴에서는 2 지점부터 4지점 중 가장 작은 값을 찾아 2지점에 있는 데이터와 교체합니다.
			네 번째 턴에서는 3 지점부터 4지점 중 가장 작은 값을 찾아 3지점에 있는 데이터와 교체합니다.
			
			위와 같이 진행하면 모든 데이터가 순차적으로 나열되며 정렬이 완성됩니다.
			배열의 크기가 달라지더라도 정렬이 가능하도록 length 항목을 활용하여 정렬을 구현해보세요.
    	 * */
    	
    	Random r = new Random();
    	int[] array = new int[10];
    	
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
    	
    	// selection sort
    	int minimum_index = 0;
    	for(int i = 0; i < array.length; i++) 
    	{
    		minimum_index = i;
    		
    		for(int j = i; j < array.length; j++)
        	{
        		if (array[j] < array[minimum_index]) 
        		{
        			minimum_index = j;
        		}
        	}
    		
    		//System.out.println("minimum_index : " + minimum_index);
        	
    		int swap = array[i];
			array[i] = array[minimum_index];
    		array[minimum_index] = swap;
    	}
    	//System.out.println("minimum_index : " + minimum_index);
    	
    	System.out.print("After : ");
    	for(int a = 0; a < array.length; a++)
    	{
    		System.out.print(array[a] + "/");
    	}
    }
}