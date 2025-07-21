package c250721oop.method2;;

public class homework 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 클래스 구성 및 인스턴스 생성 문제
oop.method2 패키지를 만들고 다음 정보를 클래스를 이용하여 인스턴스로 생성하세요.
단, init 메소드를 이용한 초기화와 info 메소드를 이용한 출력을 구현하셔야 합니다.

추가 요구사항
행사중인 상품은 상품명 옆에 (행사중) 이라고 추가 출력
행사중인 상품은 20% 할인된 가격으로 출력
    	 * */
    	
    	menu americano = new menu();
    	menu moca = new menu();
    	menu cheese = new menu();
    	menu maca = new menu();
    	
    	americano.init("아메리카노", "음료", 2500, true);
    	moca.init("모카라떼", "음료", 3500, false);
    	cheese.init("치즈케이크", "디저트", 5000, true);
    	maca.init("마카롱", "디저트", 3000, false);
    	
    	americano.info();
    	moca.info();
    	cheese.info();
    	maca.info();
    }
}