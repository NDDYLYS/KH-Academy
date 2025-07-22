package c250722oop.method3;;

public class Goods 
{
	String name;
	String category;
	int price;
	float sale;
	int count;
	boolean delivery;
	
	void init(String name, String category,	int price, float sale, int count, boolean delivery) 
	{
		this.name = name;
		this.category = category;
		this.price = price;
		this.sale = sale;
		this.count = count;
		this.delivery = delivery;
	}
	
	void info() 
	{
		int temp = 0;
		if (delivery) // 새벽배송 가능
			temp += 3000;
		
		if (sale <= 0.0f)
		{
		// 할인 안함
			System.out.println(name + "(" + category + "). 주문금액 : " + (temp + count * price) + "원");
		}
		else 
		{
		// 할인함	
			System.out.println(name + "(" + category + "). 주문금액 - 원가 : " + (temp + (count * price)) + "원 할인된 금액 : " + (temp + (count * price) - (count * price * sale)) + "원");
		}
	}
}