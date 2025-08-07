package c250725api.lang.string2;;

public class Test01전화번호검사 
{
    public static void main(String[] args) 
    {
    	// 사용자가 입력한 휴대전화번호가 올바른 양식인지 검사하여 출력
    	String input = "010-6285-4967";
    	
//    	char first = input.charAt(0);
//    	boolean start = first == '0';
//    	
//    	char forth = input.charAt(4);
//    	boolean numberic = forth >= '0' && forth <= '9';
    	
    	String regex = "^010-[1-9][0-9]{3}-[0-9]{4}$";
    
    	boolean match = input.matches(regex);
    	
    	if (match)
    		System.out.println("올바르다");
    	else
    		System.out.println("잘못");
    }
}