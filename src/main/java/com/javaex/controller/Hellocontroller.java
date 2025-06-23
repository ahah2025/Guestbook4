package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class Hellocontroller {
	
	//필드
	//생성자
	//메소드gs	
	//메소드일반
	@RequestMapping(value="/user/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String select() {
		System.out.println("guestbook4/list");
	
		return "";
	}	
	
	@RequestMapping(value="/user/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete() {
		System.out.println("guestbook4/remove");
		
		return "/WEB-INF/views/hello.jsp";
	}

}
