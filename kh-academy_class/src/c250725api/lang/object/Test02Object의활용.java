package c250725api.lang.object;

import java.util.Scanner;

public class Test02Object의활용 
{
    public static void main(String[] args) 
    {
    	// Object는 최상위 클래스이다
    	// 그렇다면 다형성 측면에서 봤을 때 모든 클래스의 인스턴스를 보관할 수 있다
    	// 즉, 아무거나라고 해석할 수 있다
    	
    	Object a = 10;
    	Object b = 3.14;
    	Object c = "hello";
    	Object sc = new Scanner(System.in);
    	Object numbers = new int[] {30, 50, 20, 10, 40};
    	Object st = new Student("", 0, 0);
    }
}