package ex5;

public class OrderSystem {
	// ���������� ����� �� ��ü!
	private MenuInter menu;
	//private KorOrder m1;
	//private IndoOrder m2;
	////private ChinaOrder m3;
	public MenuInter getMenu() {
		return menu;
	}
	public void setMenu(MenuInter menu) {
		this.menu = menu;
	}
	public String printMenu(String orderName){
		return menu.order(orderName);
	}
	
}
