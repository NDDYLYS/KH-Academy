package c250724oop.etc;;

public class Test01익명중첩클래스 
{
    public static void main(String[] args) 
    {
    	// anonymous inner class
    	// - 상속을 받아 필요한 내용을 그치면서 인스턴스를 생성
    	
    	Button b = new Button() 
    	{
    		@Override
    		public void push() 
    		{
    			
    		}
    	};
    	
    	b.push();
    	
    	Button2 b2 = new Button2() 
    	{
    		@Override
    		public void push() 
    		{
    			
    		}
    	};
    	
    	b2.push();
    	
    	// 다음 조건을 만족하면 코드를 과감하게 생략 가능
    	// 1. 인터페이스일 것
    	// 2. 메소드가 1개일 것
    	Button2 b3 = ()->{};
    	b3.push();
    }
}