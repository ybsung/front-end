package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;
//  Exam2_DI �� ���� �ؼ� 
// new�� spring���� ���ӽ��Ѽ� ���������� ���ư����� ����..
public class Exam_Todate {
	private String todate, name;
	public void setName(String name) { // value���� ����
		this.name = name;
	}
	public Exam_Todate() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		todate = f.format(new Date());
	}
	public String printDate(){
		return todate+"/"+name;
	}
	
}
