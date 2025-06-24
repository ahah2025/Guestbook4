package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Controller
public class Guestbookcontroller {

	//필드
	//생성자
	//메소드 gs
	//메소드일반
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("Guestbookcontroller.list()");
		
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookVO> guestbooklist = guestbookDAO.guestbookSelect();
		System.out.println(guestbooklist);
		
		//*Model개념
		//DispatcherServlet 야!!
		//request의 어트리뷰트영역에
		//"gList" 이름으로 0x333(guestbookList) 을 넣어줘
		model.addAttribute("glist",guestbooklist);
		
		//*views 개념
		//DispatcherServlet 야!!
		// "/WEB-INF/views/addlist.jsp" 에 포워드해
		return "/WEB-INF/views/addList.jsp";
	}
	
}
