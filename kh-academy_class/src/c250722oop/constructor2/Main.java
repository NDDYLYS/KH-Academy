package c250722oop.constructor2;;

public class Main 
{
    public static void main(String[] args) 
    {
    	character a = new character("장발장", "도둑", 15, 100);
    	character b = new character("허준", "성직자", 10, 10);
    	character c = new character("나폴레옹", "전사", 20, 500);
    	
    	a.info();
    	b.info();
    	c.info();
    }
}
