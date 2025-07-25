package c250725api.lang.string;;

public class Test07문자열편집 
{
    public static void main(String[] args) 
    {
    	// 문자열 편집
    	// 대소문자 변환, 마스킹 처리, 치환, 분힐, 공백제거
    	// 문자열은 불변
    	// 편집 명령을 실헹하면 기존 문자열이 변하는게 아니고 신규 문자열이 생성됨
    	
    	String a = "Hello1234";
    	String b = a.toUpperCase();
    	System.out.println("a = " + a); //이전
    	System.out.println("b = " + b); //이후
    	
    	String c = "                      as d                     ";

    	System.out.println("여백제거 이전 : " + c);
    	System.out.println("여백제거 이후 : " + c.trim());
    	
    	String d = "\u2003\u2003\u2003\u2003\u2003\u2003\u2003\u2003\u2003";
    	System.out.println("여백제거 이전 : " + "12312354" + d + "12312354");
    	System.out.println("여백제거 이후 : " + "12312354" + d.trim() + "12312354"); // 자바 11 이전
    	System.out.println("여백제거 이후 : " + "12312354" + d.strip() + "12312354"); // 자바 11 이후
    	
    	// 문자열 치환
    	String e = "저는 죽을게요.";
    	//System.out.println("before : " + e.replace(0, 0));
    	//System.out.println("after : " + e.replace(, 0));
    }
}
