package ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex6_AutoWired1 {
	@Autowired
	@Qualifier("h")
	private String name;
	//ByName���� �˻��� ��. bean�� ���̵� �̸��� �˻��� property�� ������ �̸��ϰ��
	//ByType���� �˻��� ��. ���� �̸��� ���� ���� ���, ���� Ÿ������ �˻�
	//	@Autowired
//	public void setName(String name) {
//		this.name = name;
//	}

	public String printName(){
		return "����� �̸���"+name+"�Դϴ�.";
	}
}
