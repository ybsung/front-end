package ex6;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Ex7_Resource {
	@Resource(name="msg2")
	private String msg;
	
	public String printMsg(){
		return "당신의 메세지 :"+msg;
	}
}
