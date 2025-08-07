package c250718;

import java.util.Scanner;

public class Test09배열뒤집기 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 배열의 자리교체 코드를 응용하여 다음 배열의 모든 자리가 뒤집힐 수 있도록 코드를 구현

			(단, 배열의 크기 변경에도 문제 없이 전부다 뒤집히도록 구현)
			
			주어진 데이터 : 30, 50, 20, 10, 40
			뒤집힌 결과물 : 40, 10, 20, 50, 30
    	 * */
    	
    	System.out.print("표현할 배열의 사이즈를 입력하세요. : ");
    	Scanner sc = new Scanner(System.in);
    	
    	int arraySize = sc.nextInt();
    	sc.close();
    	
    	int[] array = new int[arraySize];
    	
    	System.out.print("Array : ");
    	for(int i = 0; i < array.length; i++) 
    	{
    		array[i] = (i + 1) * 10;
    		System.out.print(array[i] + " ");
    	}
    	
    	for(int i = 0; i < array.length; i++) 
    	{
    		/*
    		int swap = array[i];
    		array[array.length - (i + 1)] = swap;
    		array[i] = array[array.length - (i + 1)];
    		*/
    	}
    	
    	System.out.println();
    	System.out.print("Reverse : ");
    	for(int i = 0; i < array.length; i++) 
    	{
    		System.out.print(array[i] + " ");
    	}
    }
}