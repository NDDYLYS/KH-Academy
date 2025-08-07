package c250730api.util.scanner;

import java.util.Scanner;
import java.util.regex.Pattern;

;

public class Test03패턴분석 
{
    public static void main(String[] args) 
    {
    	//String rainbow = "red orange yellow greeb blue deepblue purple";
    	String rainbow = "red+ora/nge+y$ellow#+gre!eb+blue+d^eepbl&ue+purple";
    	Scanner sc = new Scanner(rainbow);
    	
    	//sc.useDelimiter("[+/$#!^&]");
    	rainbow = rainbow.replaceAll("[가-힣]+", rainbow);
    	
    	while(sc.hasNext()) 
    	{
    		String color = sc.next();
    		System.out.println("color : " + color);
    	}
    	sc.close();
    }
}