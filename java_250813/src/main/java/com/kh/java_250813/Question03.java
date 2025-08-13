package com.kh.java_250813;

import java.util.Scanner;

public class Question03 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("아이피를 입력해주세요.(aaa.bbb.ccc.ddd) : ");
		String ip = sc.nextLine();
		
		// 정규식이 잘못되었음
		String regex = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
		boolean matches = ip.matches(regex);
		System.out.println("아이피 : " + ip + ", 정규식 통과 : " + matches);
		
		// 정규식의 시작과 끝이 없음
	}
}
