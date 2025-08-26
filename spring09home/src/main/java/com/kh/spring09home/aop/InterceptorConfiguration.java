package com.kh.spring09home.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// application.properties에서 할 수 없는 프로그래밍 설정을 수행한다

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer
{
	@Autowired
	private TestInterceptor testInterceptor;
	@Autowired
	private MemberLoginInterceptor memberLoginInterceptor;
	@Autowired
	private AdvencedMemberInterceptor advencedMemberInterceptor;
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) // 인터셉터 등록메소드
	{
		//registry.addInterceptor(testInterceptor).addPathPatterns("/**");
		registry.addInterceptor(memberLoginInterceptor)
		.addPathPatterns("/student/**", "book/**", "/member/**")
		.excludePathPatterns("/member/join*", 
				"/member/login", "/member/goodbye").order(1);
		
		registry.addInterceptor(advencedMemberInterceptor)
		.addPathPatterns("book/**").order(2);
		
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/member/list").order(3);
	}
}
