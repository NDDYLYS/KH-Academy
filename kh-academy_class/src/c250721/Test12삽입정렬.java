package c250721;

import java.util.Random;

public class Test12삽입정렬 
{
    public static void main(String[] args) 
    {
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
    	
    	// insertion sort
    	// 삽입될 위치를 찾아 데이터를 넣어주는 방식의 정렬
    	// 비교하여 더 작은 값이 나오면 중지
    	
    	for(int k=1 ; k < array.length ; k++) {
			//- [k] 지점에 있는 데이터를 백업한다
			int position = k;//돌아갈위치
			int backup = array[k];//백업할데이터
			//- [k-1] 지점의 데이터와 비교하여 더 작은 값이 나오면 중지
			for(int i=k-1; i >= 0; i--) {
				//System.out.println("backup = " + backup + ", numbers[i] = " + numbers[i]);
				if(backup >= array[i]) {//만약 작거나 같은 데이터가 발견되면 탐색중지
					break;
				}
				else {//더 큰 데이터가 앞에서 발견된다면
					array[i+1] = array[i];//현재 위치의 값을 오른쪽으로 복사
					position--;//위치를 한칸 왼쪽으로 조정
				}
			}
			array[position] = backup;//만들어진 자리에 백업데이터를 복사
		}
    	
    	System.out.print("After : ");
    	for(int a = 0; a < array.length; a++)
    	{
    		System.out.print(array[a] + "/");
    	}
    }
}