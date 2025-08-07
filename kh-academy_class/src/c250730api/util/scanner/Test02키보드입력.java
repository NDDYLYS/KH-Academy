package c250730api.util.scanner;

import java.util.Scanner;

;

public class Test02키보드입력 
{
    public static void main(String[] args) 
    {
    	// 표준 입력 통로(System.in)를 읽는 법
    	// ISO-8859-1 / MS949 / UTF-8
    	// sc.nextLine(); 한 번 더 쓴다
     	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("이름 : ");
    	String name = sc.next();
    	
    	System.out.print("나이 : ");
    	int age = sc.nextInt();
    	sc.nextLine();
    	
    	System.out.print("주소 : ");
    	String address = sc.nextLine();
    	
    	
    	sc.close();
    	
    	System.out.println("이름 : " + name);
    	System.out.println("나이 : " + age);
    	System.out.println("주소 : " + address);
    }
}