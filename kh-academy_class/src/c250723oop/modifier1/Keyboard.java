package c250723oop.modifier1;;

public class Keyboard 
{
	// 멤버필드는 외부에서 접근이 불가능하게 하고 샆다
	private String name;
	private String type;
	private int key;
	private int price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Keyboard(String name, String type, int key, int price) 
	{
		this.setName(name);
		this.setType(type);
		this.setKey(key);
		this.setPrice(price);
	}
	
	public void info() 
	{
		System.out.println("키보드 상품 정보");
	}
	

	
	
}