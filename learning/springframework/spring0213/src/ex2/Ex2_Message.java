package ex2;
//���� �߰� ��ų �� �ִ� ����� �⺻ 2���� setter, ������ 
public class Ex2_Message {
	private Ex2_Resource resource;

	public Ex2_Message() {
	}
	public Ex2_Message(Ex2_Resource resource) {
		this.resource = resource;
	}
	public void setResource(Ex2_Resource resource) {
		this.resource = resource;
	}
	public String msgPrint(){
		String name = resource.getName();
		return name+"�� �ȳ��ϼ���!";
	}
}
