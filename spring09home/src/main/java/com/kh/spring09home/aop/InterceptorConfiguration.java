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
	@Autowired
	private PreventAdminInterceptor preventAdminInterceptor;
	@Autowired
	private BoardOwnerInterceptor boardOwnerInterceptor;
	@Autowired
	private BoardReadIntercepter boardReadIntercepter;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) // 인터셉터 등록메소드
	{
		//registry.addInterceptor(testInterceptor).addPathPatterns("/**");
		registry.addInterceptor(memberLoginInterceptor)
		.addPathPatterns("/student/**", "/book/**", "/member/**", "/admin/**", 
				"/board/**")
		.excludePathPatterns("/member/join*", 
				"/member/login", "/member/goodbye", 
				"/board/list*", "/board/detail").order(1);
		
		registry.addInterceptor(advencedMemberInterceptor)
		.addPathPatterns("/book/**").order(2);
		
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/admin/**").order(3);
		
		registry.addInterceptor(preventAdminInterceptor)
		.addPathPatterns("/admin/member/detail", "/admin/crud/edit", "/admin/crud/drop")
		.order(4);
		
		registry.addInterceptor(boardOwnerInterceptor)
		.addPathPatterns("/board/update", "/board/delete")
		.order(5);
		
		registry.addInterceptor(boardReadIntercepter)
		.addPathPatterns("/board/detail")
		.order(6);
	}
}
