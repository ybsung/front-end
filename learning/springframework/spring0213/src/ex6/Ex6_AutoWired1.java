package ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex6_AutoWired1 {
	@Autowired
	@Qualifier("h")
	private String name;
	//ByName으로 검색을 함. bean의 아이디나 이름이 검색할 property와 동일한 이름일경우
	//ByType으로 검색을 함. 같은 이름의 빈이 없을 경우, 같은 타입으로 검색
	//	@Autowired
//	public void setName(String name) {
//		this.name = name;
//	}

	public String printName(){
		return "당신의 이름은"+name+"입니다.";
	}
}
