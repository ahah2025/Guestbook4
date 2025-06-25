package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class Guestbookcontroller {

	//필드
	@Autowired
	private GuestbookService guestbookService;
	
	//생성자
	//메소드 gs
	//메소드일반
	//-방명록 전체 리스트 가져오기
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("Guestbookcontroller.list()");
		
		//service
		
		
		//guestbookService 메모리에 올려주세요
		//주소 0x333 주입 해주세요
		//GuestbookService guestbookService = new GuestbookService();
		List<GuestbookVO> guestbookList = guestbookService.exeGetGuestbookList();
		
		//*Model개념
		//DispatcherServlet 야!!
		//request의 어트리뷰트영역에
		//"gList" 이름으로 0x333(guestbookList) 을 넣어줘
		model.addAttribute("glist",guestbookList);
		
		//*views 개념
		//DispatcherServlet 야!!
		// "/WEB-INF/views/addlist.jsp" 에 포워드해
		return "addList";
	}
	
	//-방명록 글 저장
	@RequestMapping(value="add",method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
					  //DispatcherServlet 야!!  Request 파라미터 값을 꺼내서
					  //GuestbookVO로 묶어줘	
		System.out.println("Guestbookcontroller.add()");
		
		/*DispatcherServlet 가 하는 일
		1)파라미터의 값을 꺼낸다
		name=정우성				setName
		password=1234           setPassword
		content=abcdefghijk		setContent
		
		2)GuestbookVO 메모리에 올린다(기본 생성자 사용)---> GuestbookVO에 디폴트 생성자를 없애면 오류 생김
		GuestbookVO guestbookVO = new GuestbookVO();
			
		3)Setter로 값을 넣는다
		name=정우성   		 -->  setName   	 
		password=1234        -->  setPassword
		content=abcdefghijk	 -->  setContent
			
		4) DispatcherServlet는 add(guestbookVO) 실행한다
			
		url 파라미터이름과 VO 필드 이름을 같게 만든다
		*/
		///////////////////////////////////////////////////////////
		
		//Service 한테 시키는 일
		//GuestbookService guestbookService = new GuestbookService();
		guestbookService.exeGuestbookAdd(guestbookVO);
		
		
		//리다이렉트 하는 방법 "redirect:" 앞쪽에 써준다
		//http://localhost:8888/guestbook4/list
		return "redirect:/list";
	}
	
	
	/* 묶어서 하는것 아님!!! "하나씩 기재"
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@RequestParam(value="name")String name, 
					  @RequestParam(value="password")String password,
					  @RequestParam(value="content")String content) {
		
		//DispatcherServlet 야!! 파라미터 영역의 name 인 값을 꺼내줘!!
		System.out.println("Guestbookcontroller.add()");

		GuestbookVO guestbookVO = new GuestbookVO();
		guestbookVO.setName(name);
		guestbookVO.setPassword(password);
		guestbookVO.setContent(content);
		
		System.out.println(guestbookVO);
		return "";
	}
	*/
	
	//삭제폼(삭제랑 헷갈리지 말것) 폼만 보여주면 됨
	@RequestMapping(value="rform",method = {RequestMethod.GET,RequestMethod.POST})
	public String removeForm() {
		System.out.println("Guestbookcontroller.removeForm()");

		return "removeform";
	}
	
	//삭제
	@RequestMapping(value="remove",method = {RequestMethod.GET,RequestMethod.POST})
	public String remove(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("Guestbookcontroller.remove()");
		System.out.println(guestbookVO);
		
		//GuestbookService guestbookService = new GuestbookService();
		guestbookService.exeGuestbookRemove(guestbookVO);
		
		return "redirect:/list";
	}
}
