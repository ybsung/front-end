package ex3;

public class Ex3_ServiceImple implements Ex3_Service{
	private int num;
	private String name, str;
	// 생성자로 주입을 받을 때는 기본적으로 String 이 기본값
	public Ex3_ServiceImple(int num) {
		this.num = num;
		System.out.println("Int 호출");
	}
	public Ex3_ServiceImple(String str) {
		this.str = str;
		System.out.println("String 호출");
	}
	public Ex3_ServiceImple(int num, String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public String print() {
		StringBuffer s  = new StringBuffer();
		int res = num * 10;
		s.append("RES :").append(res);
		return s.toString();
	}
	@Override
	public String call() {
		StringBuffer s  = new StringBuffer();
		s.append(str).append("★");
		return s.toString();
	}
	@Override
	public String moniter() {
		StringBuffer s  = new StringBuffer();
		int res = num + 10;
		s.append("RES :").append(res);
		s.append("Name:").append(name);
		return s.toString();
	}
	

}
