package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Controller
public class Guestbookcontroller {

	//필드
	//생성자
	//메소드 gs
	//메소드일반
	//-방명록 전체 리스트 가져오기
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
	
	//-방명록 글 저장
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@RequestParam(value="name")String name, 
					  @RequestParam(value="password")String password,
					  @RequestParam(value="content")String content) {
		
		//DispatcherServlet 야!! 파라미터 영역의 name 인 값을 꺼내줘!!
		System.out.println("Guestbookcontroller.add()");

		System.out.println(name);
		
		//DispatcherServlet 야!! 파라미터 영역의 password 인 값을 꺼내줘!!
		System.out.println(password);
		System.out.println(content);
		
		return "";
	}
}
