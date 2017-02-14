package ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex6_AutoWired {
	//byName : property와 같은 이름의 빈을 찾아서 묶어준다.
	//byType : property와 같은 타입의 빈을 찾아서 묶어준다.
	@Autowired
	@Qualifier("h")
	private String name;
	
	public String printName(){
		return "당신의 이름은"+name+"입니다.";
	}
}
