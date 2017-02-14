package ex2;
//값을 추가 시킬 수 있는 방법은 기본 2가지 setter, 생성자 
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
		return name+"님 안녕하세요!";
	}
}
