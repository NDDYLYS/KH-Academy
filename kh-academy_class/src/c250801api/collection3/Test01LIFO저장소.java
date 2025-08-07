package c250801api.collection3;

import java.util.Stack;

;

public class Test01LIFO저장소 
{
    public static void main(String[] args) 
    {
    	// Last In First Out
    	// - Stack
    	
    	Stack<String> stack = new Stack<>();
    	stack.push("");
    	
    	stack.peek();
    	stack.pop(); // undo, 뒤로 가기
    }
}