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
		//View�� �̸��� ����
		mav.setViewName("sayhello");
		//���� ���� 
		mav.addObject("msg", "�ȳ��ϼ���~^^");
		return mav;
	}
	
	
	
	
}
