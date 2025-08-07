package c250729api.lang.etc;

import java.io.IOException;

;

public class Test03Runtime 
{
    public static void main(String[] args) 
    {
    	// Runtime
    	// 직접 생성은 불가능하지만 생성명령이 존재하는 클래스
    	// 외부 실행 환경과 연결할 수 있는 클래스
    	
    	Runtime run = Runtime.getRuntime();
    	
    	System.out.println(run.availableProcessors()); // 코어의 개수
    	System.out.println(run.freeMemory()); // 여유 메모리
    	// run.exec("실핼 명령");
    	try 
    	{
    		// run.exec("notepad"); // 가로줄이 쳐지는 이유 : 없어질 확률이 높다 비추천Deprecated 메소드
    		// run.exec(new String[] {"cmd", "/c", "notepad"});
    		// run.exec(new String[]{"open", "-a", "TextEdit.app"});
    		run.exec(new String[] {"cmd", "/c", "start", "https://iei.or.kr"});
    	}
    	catch (IOException e) 
    	{
    		
    	}
    }
}