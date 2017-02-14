package ex1;

public class Ex1_MessageApp {
	private String msg;
	//property ==> setter호출
	//Spring은 외부 조립기 역할, 객체들의 관계를 맞추어 주는 역할...
	//스프링컨테이너는 싱글톤 레지스터리가 있어서 빈으로 등록하는 모든
	//객체를 싱글톤레지스터리에 등록 해놓고 사용한다. 
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String printMsg(){
		StringBuffer sb  = new StringBuffer();
		sb.append("당신이 입력한 메세지:").append(msg);
		sb.append("입니다.");
		return sb.toString();
	}
}
