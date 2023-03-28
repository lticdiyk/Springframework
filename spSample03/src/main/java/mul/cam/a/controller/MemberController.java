package mul.cam.a.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.cam.a.dto.MemberDto;
import mul.cam.a.service.MemberService;
import mul.cam.a.service.impl.MemberServiceImpl;

@Controller
public class MemberController {
	// service 접근(생성)
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<MemberDto> list = service.allMember();
		model.addAttribute("list", list); // 짐싸!
		
		return "home";	// home.jsp로 잘가	
	}
	
	@ResponseBody    // -> ajax 통신을 의미
	@RequestMapping(value = "idcheck.do", 
					method = RequestMethod.GET,
					produces="application/String; charset=utf-8")
	public String idcheck(String id) {		
		System.out.println("id:" + id);
		
		String message = "오케이";
		return message;
	}
	
	@ResponseBody
	@RequestMapping(value = "account.do", method = RequestMethod.POST)
	public List<MemberDto> account(MemberDto dto){
		System.out.println(dto.toString());
		
		List<MemberDto> list = new ArrayList<>();
		list.add(new MemberDto("abc", "123", "abc", "aemail", 0));
		list.add(new MemberDto("bcd", "234", "bcd", "bemail", 0));
		list.add(new MemberDto("cde", "345", "cde", "cemail", 0));
				
		return list;
	}
	
}










