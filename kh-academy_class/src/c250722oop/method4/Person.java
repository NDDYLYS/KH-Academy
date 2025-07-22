package c250722oop.method4;;

public class Person 
{
	String name;
	int age;
	
	void init(String name, int age) 
	{
		setName(name);
		setAge(age);
	}
	
	void info() 
	{
		System.out.println("이름 : " + name + "(" + age + "세)");
		
	}
	
	void growup() 
	{
		age++;
	}
	
	void setName(String name) 
	{
		this.name = name;
	}
	
	void setAge(int age) 
	{
		if (age < 1)
			return;
		this.age = age;
	}
	
	// 세터메소드
	// 필드를 개별적을 설정하는 메소드
}