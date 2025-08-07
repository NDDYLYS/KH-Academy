package c250721oop.basic3;;

public class 클래스인스터스생성문제2 
{
    public static void main(String[] args) 
    {
    	olympics a = new olympics("진종오", "사격", "하계", 4, 2, 0);
    	olympics b = new olympics("김수녕", "양궁", "하계", 4, 1, 1);
    	olympics c = new olympics("전이경", "쇼트트랙", "동계", 4, 0, 1);
    	
    	a.PrintAll();
      	b.PrintAll();
      	c.PrintAll();
      	
    	a.PrintMedalScore();
      	b.PrintMedalScore();
      	c.PrintMedalScore();
    }
}