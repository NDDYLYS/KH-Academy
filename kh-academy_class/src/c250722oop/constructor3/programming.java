package c250722oop.constructor3;;

public class programming 
{
	String course;
	String type;
	int lecture_time;
	int tuition_fee;
	String teaching_method;
	
	public programming(String course, String type, int lecture_time, 
			int tuition_fee) 
	{
		this(course, type, lecture_time, tuition_fee, "오프라인");
	}
	public programming(String course, String type, int lecture_time, 
			int tuition_fee, String teaching_method) 
	{
		setCourse(course);
		setType(type);
		setLecture_time(lecture_time);
		setTuition_fee(tuition_fee);
		setTeaching_method(teaching_method);
	}
	
	String getCourse() {
		return course;
	}

	void setCourse(String course) {
		this.course = course;
	}

	String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	int getLecture_time() {
		return lecture_time;
	}

	void setLecture_time(int lecture_time) {
		if (lecture_time < 0)
			return;
		int lecture = lecture_time % 30;
		if (lecture == 0)
			this.lecture_time = lecture_time;
	}

	int getTuition_fee() {
		return tuition_fee;
	}

	void setTuition_fee(int tuition_fee) {
		if (tuition_fee < 0)
			return;
		if (tuition_fee % 1000 == 0)
			this.tuition_fee = tuition_fee;
	}

	String getTeaching_method() {
		return teaching_method;
	}

	void setTeaching_method(String teaching_method) {
		switch(teaching_method) 
		{
		case "온라인" :
		case "오프라인" :
		case "혼합" :
			this.teaching_method = teaching_method;
			break;
		}		
	}
	
	void info() 
	{
		System.out.println("<강좌 정보>");
		System.out.println("강좌명 : " + getCourse() + ", 구분 : " + getType() + 
				", 강의시간 : " + getLecture_time() + "분, 수강료 : " + getTuition_fee() + 
				"원, 수업형태 : " + getTeaching_method());
	}
}