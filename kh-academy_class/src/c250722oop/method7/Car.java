package c250722oop.method7;;

public class Car 
{
	String name;
	int releaseYear;
	int maximumSpeed;
	String type;
	
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		if (releaseYear < 2000)
			return;
		this.releaseYear = releaseYear;
	}
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	public void setMaximumSpeed(int maximumSpeed) {
		if (maximumSpeed <= 0)
			return;
		this.maximumSpeed = maximumSpeed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		switch(type) 
		{
		case "휘발유": 
		case "하이브리드":
		case "디젤":
		case "전기차":
			this.type = type;
			break;
		}
	}
	
	void init(String name, int releaseYear, int maximumSpeed, String type)
	{
		setName(name);
		setReleaseYear(releaseYear);
		setMaximumSpeed(maximumSpeed);
		setType(type);
	}
	
	void info () 
	{
		System.out.print("자동차 정보 - ");
		System.out.print("이름 : " + this.getName() + " ");
		System.out.print("출시년도 : " + this.getReleaseYear() + "년 ");
		System.out.print("최고시속 : " + this.getMaximumSpeed() + "km ");
		System.out.print("종류 : " + this.getType() + " ");
		System.out.print("에너지 효율 : " + this.getEnegyEfficiency());
		System.out.println();
	}
	
	String getEnegyEfficiency() 
	{
		String energy = "C";
		//출시한지 5년 이하이면서 전기차, 하이브리드라면 A등급
		//출시한지 10년 이하이면서 전기차, 하이브리드, 휘발유라면 B등급
		int year = 2025 - getReleaseYear() + 1;
		if (year <= 5) 
		{
			switch(getType()) 
			{
			case "하이브리드":
			case "전기차":
				return "A";
			}
		}
		if (year <= 10) 
		{
			switch(getType()) 
			{
			case "휘발유": 
			case "하이브리드":
			case "전기차":
				return "B";
			}
		}
		
		return energy;
	}
}