package c250721oop.basic1;;

public class Test01객체지향프로그래밍 
{
    public static void main(String[] args) 
    {
    	// Message
    	// 사진 보낸사람(String))(발신자) 내용(String) 보낸시각(String)
    	// 안읽은사람수(int)
    	
    	Message a = new Message();
    	a.sender = "";
    	a.content = "";
    	a.time = "";
    	a.remain = 0; 
    	
    	System.out.println(a.sender);
    	System.out.println(a.content);
    	System.out.println(a.time);
    	System.out.println(a.remain);
    	
    	Message b = new Message();
     	
    	b.sender = "";
     	b.content = "";
     	b.time = "";
     	b.remain = 0;
    	 
     	System.out.println(b.sender);
     	System.out.println(b.content);
     	System.out.println(b.time);
     	System.out.println(b.remain);
    }
}