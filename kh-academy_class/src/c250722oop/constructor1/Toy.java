package c250722oop.constructor1;;

public class Toy 
{
	String name;
	int price;
	
	public Toy(String name, int price)
	{
		setName(name);
		setPrice(price);
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		if (price < 0)
			return;
		this.price = price;
	}
}