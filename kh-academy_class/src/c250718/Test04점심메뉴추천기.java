package c250718;

import java.util.Random;
import java.util.Scanner;

;

public class Test04점심메뉴추천기 
{
    public static void main(String[] args) 
    {
    	// 사용자에게 5개의 메뉴를 입력 받은 뒤
    	// 입력받은 메뉴를 모두 출력하고 추가로 그 중 하나를 골라서 출력

    	Scanner sc = new Scanner(System.in);
    	Random r = new Random();
    	// String a = sc.next(); 띄어쓰기는 넣을 수 없다
    	
    	int menuCount = 5;
    	String[] menus = new String[menuCount];
    	for(int i = 0; i < menuCount; i++) 
    	{
    		System.out.print("메뉴를 추천해주세요. : ");
    		menus[i] = sc.next();
    	}
    	
    	sc.close();
    	
    	for(int i = 0; i < menuCount; i++) 
    	{
    		System.out.println("추천 받은 메뉴 : " + menus[i]);
    	}
    	
    	int ran = r.nextInt(menuCount);
    	System.out.println("랜덤으로 추천된 메뉴는 \"" + menus[ran] + "\"입니다.");
    	
    }
}