package c250723oop.keyword4;;

public class Member 
{
	private final String id;
	private String pw;
	private String nickname;
	
	// final 항목은 반드시 생성자에서 초기화가 되어야 한다
	public Member(String id, String pw, String nickname) 
	{
		this.id = id;
		this.setPw(pw);
		this.setNickname(nickname);
	}
	// final은 setter를 만들 수 없다

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}