package ex1;

public class Ex1_MessageApp {
	private String msg;
	//property ==> setterȣ��
	//Spring�� �ܺ� ������ ����, ��ü���� ���踦 ���߾� �ִ� ����...
	//�����������̳ʴ� �̱��� �������͸��� �־ ������ ����ϴ� ���
	//��ü�� �̱��淹�����͸��� ��� �س��� ����Ѵ�. 
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String printMsg(){
		StringBuffer sb  = new StringBuffer();
		sb.append("����� �Է��� �޼���:").append(msg);
		sb.append("�Դϴ�.");
		return sb.toString();
	}
}
