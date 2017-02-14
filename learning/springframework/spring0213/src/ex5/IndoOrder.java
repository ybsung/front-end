package ex5;

public class IndoOrder implements MenuInter{

	@Override
	public String order(String orderName) {
		StringBuffer sb = new StringBuffer();
		sb.append("오늘은  인도 요리를 주문하셨군요 ^^");
		sb.append(orderName).append("/ 200000 won");
		return sb.toString();
	}

}
