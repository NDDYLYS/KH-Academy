package c250722oop.method5;;

public class agency 
{
	String name;
	String telecom;
	int price;
	int contract;
	
	void init(String name, String telecom, int price, int contract) 
	{
		setName(name);
		setTelecom(telecom);
		setPrice(price);
		setContract(contract);
	}
	
	void setName(String name) 
	{
		this.name = name;
	}
	
	void setTelecom(String telecom) 
	{
//		if (telecom == "SK" || telecom == "KT" || telecom == "LG" || telecom == "알뜰폰")
//			this.telecom = telecom;
		
		switch(telecom) 
		{
		case "SK" : 
		case "KT" : 
		case "LG" : 
		case "알뜰폰" : 
			this.telecom = telecom;
			break;
		}
	}
	
	void setPrice(int price)
	{
		if (price <= 0)
			return;
		this.price = price;
	}
	
	void setContract(int contract) 
	{
		if (contract == 0 || contract == 24 || contract == 30 || contract == 36)
			this.contract = contract;
	}
	
	void info() 
	{
		System.out.println("이름 : " + this.name + ", 통신사 : " + telecom +", 판매가 : " + price + "원, 약정기간 : " + contract + "개월");
		
		if (0 < contract) 
		{
			int temp = this.price / this.contract;
			System.out.println("월 분납금 : " + temp + "원");
		}
	}
}