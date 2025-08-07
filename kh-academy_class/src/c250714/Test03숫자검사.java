package c250714;

import java.util.Random;

public class Test03숫자검사 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Random random = new Random();
		
		int ran = 71;
		
		boolean ten = (ran / 10) == 7;
		boolean one = (ran % 10) == 7;

		boolean two = ran % 2 == 0;
		boolean three = ran % 3 == 0;
		boolean seven = ((ten == true) || (one == true));
		// boolean seven = !((ten == false) && (one == false)); 
		System.out.println(ran);
		System.out.println(two);
		System.out.println(three);
		System.out.println(seven);
	}
}