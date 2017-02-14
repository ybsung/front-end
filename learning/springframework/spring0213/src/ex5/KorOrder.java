package ex5;

public class KorOrder implements MenuInter{

	@Override
	public String order(String orderName) {
		StringBuffer sb = new StringBuffer();
		sb.append("오늘의 메인 코스인 한식을 주문하셨군요 ^^");
		sb.append(orderName).append("/ 100000 won");
		return sb.toString();
	}

}
