package c250722oop.method6;;

public class Student 
{
	String name;
	int korean;
	int english;
	int math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		if (korean < 0)
			return;
		if (100 < korean)
			return;
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		if (english < 0)
			return;
		if (100 < english)
			return;
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		if (math < 0)
			return;
		if (100 < math)
			return;
		this.math = math;
	}
	
	void init(String name, int korean, int english, int math) 
	{
		setName(name);
		setKorean(korean);
		setEnglish(english);
		setMath(math);
	}
	
	void info() 
	{
		// 이름
		// 국어
		// 영어
		// 수학
		// 총점
		// 평균
	}
	
	int getTotal() 
	{
		return this.getKorean() + this.getEnglish() + this.getMath();
	}
}