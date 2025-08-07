package c250722oop.method5;

import c250722oop.method4.Person;

;

public class Main 
{
    public static void main(String[] args) 
    {
    	agency handphone01 = new agency();
    	agency handphone02 = new agency();
    	agency handphone03 = new agency();
    	agency handphone04 = new agency();
  
    	handphone01.init("갤럭시Fold6", "SK", 2200000, 0);
    	handphone02.init("갤럭시Fold6", "KT", 2150000, 24);
    	handphone03.init("아이폰16", "LG", 2100000, 36);
    	handphone04.init("아이폰16", "SK", 2150000, 0);
    	
    	handphone01.info();
    	handphone02.info();
    	handphone03.info();
    	handphone04.info();
    }
}