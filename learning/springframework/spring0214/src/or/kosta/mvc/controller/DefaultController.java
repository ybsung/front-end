package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	// 기본 페이지 설정
	@RequestMapping(value={"/index"})
	public String defaultPage(){
		System.out.println("test");
		return "index";
	}
}
