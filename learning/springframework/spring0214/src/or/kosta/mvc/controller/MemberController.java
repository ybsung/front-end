package or.kosta.mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.kosta.mvc.dao.MemberDao;
import or.kosta.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao meberDao;
	
	@RequestMapping(value="/memberjoin")
	public String memForm(){
		return "member";
	}
	@RequestMapping(value="/addmember",method=RequestMethod.POST)
	public ModelAndView memberAdd(MemberVO v){
		System.out.println("아이디 검수:"+v.getId()+","+v.getName());
		
		meberDao.addMember(v);
		
		ModelAndView mav = new ModelAndView("success");
		mav.addObject("vo", v);
		return mav;
	}
}




