package jdbc.dto;

import java.sql.Timestamp;

public class MemberDto 
{
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String memberBirth;
	private String memberContact;
	private String memberEmail;
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberNickname=" + memberNickname + ", memberBirth=" + memberBirth
				+ ", memberContact=" + memberContact + ", memberEmail=" + memberEmail + ", memberLevel=" + memberLevel
				+ ", memberPoint=" + memberPoint + ", memberPost=" + memberPost + ", memberAddress1=" + memberAddress1
				+ ", memberAddress2=" + memberAddress2 + ", memberJoin=" + memberJoin + ", memberLogin=" + memberLogin
				+ ", memberChange=" + memberChange + "]";
	}

	private String memberLevel;
	private int memberPoint;
	private String memberPost;
	private String memberAddress1;
	private String memberAddress2;
	private Timestamp memberJoin;
	private Timestamp memberLogin;
	private Timestamp memberChange;
	
	public MemberDto() {
		super();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberContact() {
		return memberContact;
	}

	public void setMemberContact(String memberContact) {
		this.memberContact = memberContact;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public String getMemberPost() {
		return memberPost;
	}

	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}

	public String getMemberAddress1() {
		return memberAddress1;
	}

	public void setMemberAddress1(String memberAddress1) {
		this.memberAddress1 = memberAddress1;
	}

	public String getMemberAddress2() {
		return memberAddress2;
	}

	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2 = memberAddress2;
	}

	public Timestamp getMemberJoin() {
		return memberJoin;
	}

	public void setMemberJoin(Timestamp memberJoin) {
		this.memberJoin = memberJoin;
	}

	public Timestamp getMemberLogin() {
		return memberLogin;
	}

	public void setMemberLogin(Timestamp memberLogin) {
		this.memberLogin = memberLogin;
	}

	public Timestamp getMemberChange() {
		return memberChange;
	}

	public void setMemberChange(Timestamp memberChange) {
		this.memberChange = memberChange;
	}
}