package c250805api.file.object;

import java.io.Serializable;

// 객체 출력을 염두에 두면 자격 획득이 필수
// 버전을 표시하여 관리하는 것을 권장(SerialVersionUID)
public class Student implements Serializable
{
	private static final long serialVersionUID = 3L;
	
	private String name;
	//private int score;
	private transient int score; // transient 저장 안됨
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}