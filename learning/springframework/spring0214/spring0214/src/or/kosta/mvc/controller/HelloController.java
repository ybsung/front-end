package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView sayhello(){
		ModelAndView mav = new ModelAndView();
		//View의 이름을 지정
		mav.setViewName("sayhello");
		//값을 지정 
		mav.addObject("msg", "안녕하세요~^^");
		return mav;
	}
	
	
	
	
}
