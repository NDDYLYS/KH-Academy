package com.kh.spring10.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Spring-boot-starter-validation을 추가하면 검사용 annotation 사용 가능
//@NotNull
//@NotEmpty
//@NotBlack
//@Size(min, max)
//@Pattern(regexp)
//@Email
//@Past
//@PastOrPresent
//@Future
//@Positive
//검사를 통과 안 하면 MethodArgumentNotValidException 발생
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@ToString(exclude={"accountPw"})
public class AccountDto {
	
	@NotBlank
	@Pattern(regexp="^[a-z][a-z0-9]{4,19}$")
	private String accountId;
	
	@NotBlank
	@Pattern(regexp="^(?=.*?[A-Z]+)(?=.*?[a-z]+)(?=.*?[0-9]+)(?=.*?[!@#$]+)[A-Za-z0-9!@#$]{8,16}$")
	private String accountPw;
	
	@NotBlank
	@Pattern(regexp="^[가-힣0-9]{2,10}$")
	private String accountNickname;
	
	@Pattern(regexp="^(19[0-9]{2}|20[0-9]{2})-((02-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$")
	private String accountBirth;
	
	@Pattern(regexp="^010[1-9][0-9]{7}$")
	private String accountContact;
	
	@NotBlank
	@Email
	private String accountEmail;
	private String accountLevel;
	private Integer accountPoint;
	
	@Pattern(regexp="^[0-9]{5,6}$")
	private String accountPost;
	
	@Size(max=100)
	private String accountAddress1;
	
	@Size(max=100)
	private String accountAddress2;
	
	// Timestamp 대신 LocalDateTime로 쓴다(myBatis가 자동 변환)
	private LocalDateTime accountJoin;
	private LocalDateTime accountChange;
	private LocalDateTime accountLogin;

}