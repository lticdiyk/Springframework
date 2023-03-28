package mul.cam.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.cam.a.dto.HumanDto;

@Controller
public class HelloController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String homeMethod() {
		// System.out.println("HelloController homeMethod() " + new Date());
		logger.info("HelloController homeMethod() " + new Date());
		
		return "home";
	}
	
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		
		// 짐싸!
		String name = "홍길동";
		model.addAttribute("name", name);	// == request.setAttribute
		
		// 잘가!
		return "home";
	}
	
	@RequestMapping(value = "world.do", method = RequestMethod.POST)
	public String world(String name, int age) {
		logger.info("HelloController world() " + new Date());
		
		System.out.println("이름:" + name);
		System.out.println("나이:" + age);
		
		return "home";
	}
	
	@RequestMapping(value = "main.do", method = RequestMethod.POST)
	public String mainMethod(HumanDto human) {
		logger.info("HelloController mainMethod() " + new Date());
		
		System.out.println(human.toString());
		
		return "home";
	}
	
//	@PostMapping
//	@GetMapping
	
//	@RequestMapping(value = "mylist.do", method = { RequestMethod.GET, RequestMethod.POST } )
	@GetMapping("mylist.do")
	public String mylist(String message, Model model) {
		logger.info("HelloController Get mainMethod() " + new Date());
		
		System.out.println("message:" + message);
		
		List<HumanDto> list = new ArrayList<>();
		
		list.add(new HumanDto("홍길동", 24));
		list.add(new HumanDto("성춘향", 16));
		list.add(new HumanDto("일지매", 22));
		
		model.addAttribute("list", list);
		
		return "home";
	}
	
}




