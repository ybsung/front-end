package ex5;

public class KorOrder implements MenuInter{

	@Override
	public String order(String orderName) {
		StringBuffer sb = new StringBuffer();
		sb.append("������ ���� �ڽ��� �ѽ��� �ֹ��ϼ̱��� ^^");
		sb.append(orderName).append("/ 100000 won");
		return sb.toString();
	}

}
