package mul.cam.a.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping(value = "login.do")
	public String login() {
		System.out.println("MemberController login() " + new Date());
		
		return "login";
	}
	
	@GetMapping(value = "bbslist.do")
	public String bbslist() {
		System.out.println("MemberController bbslist() " + new Date());
		
		return "bbslist";
	}
}







