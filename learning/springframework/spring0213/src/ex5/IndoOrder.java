package ex5;

public class IndoOrder implements MenuInter{

	@Override
	public String order(String orderName) {
		StringBuffer sb = new StringBuffer();
		sb.append("������  �ε� �丮�� �ֹ��ϼ̱��� ^^");
		sb.append(orderName).append("/ 200000 won");
		return sb.toString();
	}

}
