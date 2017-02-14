package ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_DI {
	private SimpleDateFormat sdf;
	private Date date;
	public String printDate(){
		String todate = sdf.format(date);
		return todate;
	}
	//new SimpleDateFormat("yyyy-MM-dd");
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
