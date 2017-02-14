package ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex6_AutoWired {
	//byName : property�� ���� �̸��� ���� ã�Ƽ� �����ش�.
	//byType : property�� ���� Ÿ���� ���� ã�Ƽ� �����ش�.
	@Autowired
	@Qualifier("h")
	private String name;
	
	public String printName(){
		return "����� �̸���"+name+"�Դϴ�.";
	}
}
