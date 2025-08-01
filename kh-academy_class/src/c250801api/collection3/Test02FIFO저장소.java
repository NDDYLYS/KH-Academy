package c250801api.collection3;

import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Test02FIFO저장소 
{
    public static void main(String[] args) 
    {
    	//Queue<String> queue = new ArrayBlockingQueue<>(10);
    	Queue<String> queue = new PriorityBlockingQueue<>(10);
    	queue.offer("처음");
    	queue.peek();
    	queue.poll();
    	// 서로 다른 두 개의 데이터가 있을 때 이 둘을 비교하는 방법을 알려줌
    	Comparator<String> c = new Comparator<String>() 
    	{	
    		@Override
    		public int compare(String o1, String o2) 
    		{
    			return o1.compareTo(o2); // 오름차순
    		};
    	};
    }
}