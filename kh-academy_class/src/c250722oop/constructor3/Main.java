package c250722oop.constructor3;

import c250722oop.constructor2.character;

public class Main 
{
    public static void main(String[] args) 
    {
    	programming a = new programming("자바 프로그래밍 기초", "IT", 60, 50000, "온라인");
    	programming b = new programming("파이썬 프로그래밍 중급", "IT", 90, 100000);
    	programming c = new programming("정보처리기사 실기", "시험", 120, 75000, "혼합");
    	programming d = new programming("정보처리기사 실기", "시험", 75, 75500);
    	a.info();
    	b.info();
    	c.info();
    	d.info();
    }
}