package com.kh.java_250813;

import java.util.ArrayList;
import java.util.List;

public class Question02 
{
	String name;//이름
	int age;//연령
	String dept;//부서(개발팀/영업팀/총무팀/기획팀)
	String level;//직급(인턴/사원/주임/대리/과장/차장)
	String gender;//성별(남/여)
	
	Question02(String name, int age, String dept, String level, String gender) 
	{
		setName(name);
		setAge(age);
		setDept(dept);
		setLevel(level);
		setGender(gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// 이름은 한글 이름만 가능하도록 설정
		String regex = "^[가-힣]+$";
		boolean matches = name.matches(regex);
		if (matches)
			this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		// 연령은 성인(20세 이상)만 가능하도록 설정
		if (age >= 20) 
			this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		// 부서는 개발팀, 영업팀, 총무팀, 기획팀 중에서만 설정 가능
		List<String> containList = new ArrayList<>();
		containList.add("개발팀");
		containList.add("영업팀");
		containList.add("총무팀");
		containList.add("기획팀");
		if (containList.contains(dept))
			this.dept = dept;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		// 직급이 없을 경우 인턴으로 설정
		if (level == null || level.equals(""))
			this.level = "인턴";
		else 
		{
			// 인턴/사원/주임/대리/과장/차장
			List<String> containList = new ArrayList<>();
			containList.add("인턴");
			containList.add("사원");
			containList.add("주임");
			containList.add("대리");
			containList.add("과장");
			containList.add("차장");
			if (containList.contains(level))
				this.level = level;	
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		// 성별은 남 또는 여 중에서만 설정 가능
		List<String> containList = new ArrayList<>();
		containList.add("남");
		containList.add("여");
		if (containList.contains(gender))
			this.gender = gender;
	}

	@Override
	public String toString() {
		// 인스턴스를 출력하면 해당 인스턴스가 가진 요약 정보가 나오게 할 것
		return "Question02 [name=" + name + ", age=" + age + ", dept=" + dept + ", level=" + level + ", gender="
				+ gender + "]";
	}
	
	//set get 함수를 추가하여 각 필드별 제한조건을 추가해야 함
	//toString 함수를 오버라이드 해야 함
}