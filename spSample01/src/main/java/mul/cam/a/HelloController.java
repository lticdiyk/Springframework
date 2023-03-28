package mul.cam.a;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// <- annotation(주석문, 지시문)
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("HelloController hello() " + new Date());
		
		return "hello";		// hello.jsp로 이동!
	}
}
