package c250731api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

;

public class 좌석예매프로그램 
{
    public static void main(String[] args) 
    {
    	/*
    	 * 	좌석 예매 프로그램
			다음 규칙에 의해 작동하는 좌석 예매 프로그램을 만들어보세요
			
			좌석은 알파벳 A열부터 Z열까지 존재합니다.
			각 열에는 1번부터 30까지의 좌석이 존재합니다.
			각 좌석은 열 번호와 순서 번호를 합쳐서 표현합니다. (ex : A5)
			사용자에게 좌석 번호를 입력받아 다음과 같이 처리하는 프로그램을 구현하세요.
    	 * */
    	List<Seat> allSeat = new ArrayList<>();
    	
    	try 
    	{
    		String[] alphabets = new String[] {	"A", "B", "C", "D", "E", 
    				"F", "G", "H", "I", "J", 
    				"K", "O", "P", "Q", "R", 
    				"S", "T", "U", "X", "Y", 
    		"Z"};
    		int numbers = 30;
    		
    		allSeat = new ArrayList<>();
    		for(String alphabet : alphabets) 
    		{
    			for(int i = 0; i < numbers; i++) 
    			{
    				Seat seat = new Seat(alphabet, i);
    				allSeat.add(seat);
    			}
    		}
    		//throw new Exception("Error");
    		Scanner sc = new Scanner(System.in);
    		while(true) 
    		{
    			System.out.print("예매할 좌석 입력 : ");
        		String select = sc.nextLine();
        		if (select.equals("종료"))
        			break;
        		
        		Seat selectSeat = null;
        		for(Seat seat : allSeat) 
        		{
        			Seat searchSeat = seat.Search(select);
        			
        			if (searchSeat != null) 
        			{
        				selectSeat = searchSeat;
        				break;
        			}
        		}
        		
        		boolean reservation = selectSeat.Reservation();
        		if (!reservation) 
        		{
        			String answer = sc.nextLine();
        			if (answer.equals("Y")) 
        			{
        				selectSeat.ReservationCancel();
        				selectSeat.setReservation(false);        				
        			}
        		}	
        		selectSeat.setReservation(true);        	
    		}    		
    	}
    	catch(Exception e) 
    	{
    		System.err.println(e.getMessage());
    	}
    	
    	System.out.println("총 [" + ReservationCount(allSeat) +"]개의 좌석 선택이 완료되었습니다. 결제 화면으로 이동합니다.");
    	System.out.println("선택된 좌석");
    	for(Seat seat : allSeat) 
    	{
    		if (seat.getReservation()) 
    		{
    			System.out.println(seat.getName());
    		}
    	}    	
    }
    
    public static int ReservationCount(List<Seat> seats) 
    {
    	if (seats == null)
    		return 0;
    	int reservation = 0;
    	for(Seat seat : seats) 
    	{
    		if (seat.getReservation())
    			reservation++;
    	}
    	
    	return reservation;
    }
}