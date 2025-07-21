package c250721oop.method2;;

public class menu 
{
  String menu_name;
  String category;
  int price;
  boolean event;
  
  void init(String menu_name, String category, int price, boolean event) 
  {
	  this.menu_name = menu_name;
	  this.category = category;
	  this.price = price;
	  this.event = event;
  }
  
  void info() 
  {
	  if (this.event)
		  System.out.println("(행사중)" + this.menu_name + "(" + this.category +") 가격 : " + (float)(this.price * 0.8f));
	  else 
		  System.out.println(this.menu_name + "(" + this.category +") 가격 : " + this.price);
  }
}