package c250722oop.method3;;

public class Main 
{
    public static void main(String[] args) 
    {
    	Goods good1 = new Goods();
    	Goods good2= new Goods();
    	Goods good3 = new Goods();
    	Goods good4 = new Goods();
    	
      	good1.init("비빔면", "라면", 16800, 0f, 2, true);
      	good2.init("크림대빵", "제과", 6500, 0f, 2, false);
      	good3.init("점보도시락", "라면", 8500, 0.05f, 3, true);
    	good4.init("공간춘", "라면", 12300, 0.2f, 3, false);
    	
    	good1.info();
    	good2.info();
    	good3.info();
    	good4.info();
    }
}