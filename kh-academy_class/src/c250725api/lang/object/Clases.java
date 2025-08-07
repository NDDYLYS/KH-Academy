package c250725api.lang.object;

import java.lang.StringBuffer;

public class Clases 
{
    public static void main(String[] args) 
    {
    	/*
    	 * api.lang.string.Test01객체생성문제
다음 요구사항에 맞게 API의 문서를 참조하여 프로그래밍 하세요.

클래스는 java.lang 패키지에 있는 StringBuffer 입니다.

객체 생성
a라는 이름으로 비어 있는 객체 생성
b라는 이름으로 hello라는 글자를 저장한 객체 생성
a와 b의 요약 정보를 출력
a와 b의 보관중인 글자수를 각각 출력
a와 b에 각각 java라는 글자를 추가
a와 b의 요약 정보와 보관 중인 글자 수를 다시 출력
    	 * */
    	
    	StringBuffer a = new StringBuffer();
    	StringBuffer b = new StringBuffer();
    	b.append("hello");
    	
    	System.out.println("a.toString() : " + a.toString());
    	System.out.println("b.toString() : " + b.toString());
    	
    	System.out.println("a.length() : " + a.length());
    	System.out.println("b.length() : " + b.length());
    	
    	a.append("java");
    	b.append("java");
    	
    	System.out.println("a.toString() : " + a.toString());
    	System.out.println("b.toString() : " + b.toString());
    	
    	System.out.println("a.length() : " + a.length());
    	System.out.println("b.length() : " + b.length());
    }
}