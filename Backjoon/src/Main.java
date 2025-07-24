import java.util.Scanner;

public class Main 
{
        public static void main(String[] args) 
        {
        	Scanner sc = new Scanner(System.in);
        	long a = sc.nextLong();
        	long b = sc.nextLong();
         	long c = sc.nextLong();
         	sc.close();
         	
         	long sum = a + b + c;
//        	int count = sc.nextInt();
//        	
//        	int[] array = new int[count];
//        	for(int i = 0; i < array.length; i++)
//        	{
//        		array[i] = sc.nextInt();		
//        	}
//        	sc.close();
//        	
//        	int min = 0;
//        	
//        	for (int i = 0; i < array.length; i++) 
//        	{
//        		if (array[min] < array[i]) 
//        		{
//        			min = i;
//        		}
//        	}
//        	
//        	System.out.println(array[min]);
        	System.out.println(sum);
        }
}