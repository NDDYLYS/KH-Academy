package c250728api.exception;

import java.util.Scanner;

public class 만나이계산기 {
	public static void main(String[] args) {
		try {//Plan A
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월일(yyyy-mm-dd) 입력 : ");
			String birth = sc.nextLine();
			sc.close();
			
			//윤년까지 고려해서 정규표현식 작성
			int year = Integer.parseInt(birth.substring(0, 4));//연도 추출 및 변환
			boolean isLeap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
			int lastNumber = isLeap ? 9 : 8;
			String regex = "^(19[0-9]{2}|20[0-9]{2})-((02-(0[1-9]|1[0-9]|2[0-"+lastNumber+"]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$";
			if(birth.matches(regex) == false) {
				throw new Exception();
			}
			
			int month = Integer.parseInt(birth.substring(5, 7));//월 추출 및 변환
			int date = Integer.parseInt(birth.substring(8, 10));//일 추출 및 변환
			
			//사용자에 대한 일수 변환
			int userDays = convertToDays(year, month, date);
			//현재날짜에 대한 일수 변환
			int currentDays = convertToDays(2025, 7, 28);
			
			//미래의 날짜는 차단
			if(userDays > currentDays) {
				throw new Exception();
			}
			
			int diff = currentDays - userDays;//날짜 수 차이를 계산
			int globalAge = diff / 365;
			
			System.out.println("당신의 만 나이는 "+globalAge+"세 입니다");
		}
		catch(Exception e) {//Plan B는 통합으로 처리
			System.out.println("처리 과정에서 오류가 발생했습니다");
		}
	}
	
	//(+추가) 연/월/일을 일로 환산하는 메소드
	public static int convertToDays(int year, int month, int date) {
		boolean isLeap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
		int days = (year - 1) * 365;
		//전달까지의 날짜 합계를 구하고
		switch(month-1) {
		case 11: days += 30;
		case 10: days += 31;
		case 9: days += 30;
		case 8: days += 31;
		case 7: days += 31;
		case 6: days += 30;
		case 5: days += 31;
		case 4: days += 30;
		case 3: days += 31;
		case 2: days += isLeap ? 29 : 28;
		case 1: days += 31;
		}
		//현재 날짜를 더해서 반환
		days += date;
		return days;
	}
}