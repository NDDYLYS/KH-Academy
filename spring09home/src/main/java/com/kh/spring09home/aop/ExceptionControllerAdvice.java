package com.kh.spring09home.aop;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.spring09home.error.NeedPermissionException;
import com.kh.spring09home.error.TargetNotfoundException;
import com.kh.spring09home.error.UnauthorizationException;

@ControllerAdvice
public class ExceptionControllerAdvice 
{
	@ExceptionHandler(TargetNotfoundException.class)
	public String notFound(TargetNotfoundException e, Model model	) 
	{
		// 컨트롤러에서 작성 가능한 코드라면 뭐든지 가능
		model.addAttribute("title", e.getMessage());
		return "/WEB-INF/views/error/notFound.jsp";
	}
	
	@ExceptionHandler(NeedPermissionException.class)
	public String needPermission(NeedPermissionException e, Model model	) 
	{
		// 컨트롤러에서 작성 가능한 코드라면 뭐든지 가능
		model.addAttribute("title", e.getMessage());
		return "/WEB-INF/views/error/needPermission.jsp";
	}
	
	@ExceptionHandler(UnauthorizationException.class)
	public String unauthorize(UnauthorizationException e, Model model	) 
	{
		// 컨트롤러에서 작성 가능한 코드라면 뭐든지 가능
		model.addAttribute("title", e.getMessage());
		return "/WEB-INF/views/error/unauthorize.jsp";
	}
	
	@ExceptionHandler(Exception.class)
	public String all(Exception e, Model model	) 
	{
		// 컨트롤러에서 작성 가능한 코드라면 뭐든지 가능
		model.addAttribute("title", e.getMessage());
		return "/WEB-INF/views/error/all.jsp";
	}
}
