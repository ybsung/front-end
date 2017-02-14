package ex5;
//Spring DI에서 다형성을 구현하기 위한 인터페이스를 설계
public interface MenuInter {
	// 주문한다.
	public String order(String orderName);
}
