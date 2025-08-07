package c250714;

public class bmi 
{
	public static void main(String[] args) 
	{
		float tall = 1.711f;
		float weight = 53f;
		
		float bmi = weight / (float)Math.pow(tall, 2);
		
		System.out.println("키는 " + (int)(tall * 100) + "cm이며 체중은 " + weight + 
				"kg인 사람의 BMI 수치는" + bmi + "입니다.");
	}
}