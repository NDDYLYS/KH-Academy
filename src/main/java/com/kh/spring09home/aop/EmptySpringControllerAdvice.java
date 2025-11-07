package com.kh.spring09home.aop;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice //컨트롤러에 간섭하는 잔소리꾼
public class EmptySpringControllerAdvice 
{
	@InitBinder
	public void InitBinder(WebDataBinder binder) 
	{
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
