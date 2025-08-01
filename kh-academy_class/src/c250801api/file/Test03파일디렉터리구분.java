package c250801api.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

;

public class Test03파일디렉터리구분 
{
    public static void main(String[] args) 
    {
    	File a = new File("files", "Sample1.txt");
    	File b = new File("files", "Sample2.txt");
    	File c = new File("files", "Sample3.txt");
      	File d = new File("files");
    	
    	System.out.println(a.getName() + "는 파일인가? " + a.isFile());
    	System.out.println(b.getName() + "는 파일인가? " + b.isFile());
    	System.out.println(c.getName() + "는 파일인가? " + c.isFile());
    	System.out.println(d.getName() + "는 파일인가? " + d.isFile());
    	
    	
    	System.out.println(a.getName() + "는 디렉터리인가? " + a.isDirectory());
    	System.out.println(b.getName() + "는 디렉터리인가? " + b.isDirectory());
    	System.out.println(c.getName() + "는 디렉터리인가? " + c.isDirectory());
    	System.out.println(d.getName() + "는 디렉터리인가? " + d.isDirectory());
    }
}