package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;
//  Exam2_DI 로 복사 해서 
// new를 spring으로 위임시켜서 정상적으로 돌아가도록 구현..
public class Exam_Todate {
	private String todate, name;
	public void setName(String name) { // value값을 주입
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
