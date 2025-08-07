package c250724oop.poly1;

import java.util.Scanner;

;

public class Main 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("노트북을 먼저 선택하세요");
    	System.out.print("1.맥북   2.갤럭시북 : ");
    	
    	Notebook notebook = null;
    	int select = sc.nextInt();
    	if (select == 1) 
    	{
    		notebook = new MacBook();
    	}
    	else if (select == 2) 
    	{
    		notebook = new GalaxyBook(); 
    	}
    	else 
    	{
    		//none
    	}
    			
    	System.out.println();
    	System.out.println("테스트할 기능을 선택하세요");
    	System.out.print("1.전원  2.동영상재생 3.타이핑 : ");
    	int command = sc.nextInt();
    	sc.close();
    	
    	System.out.println();
    	notebook.execute(command);
    }
}