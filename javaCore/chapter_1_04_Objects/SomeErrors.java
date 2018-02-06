package chapter_1_04_Objects;

import java.util.Date;

public class SomeErrors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test t = new Test(new Date());
		Date d = t.getDate();
		System.out.println("get: " + d);
		d.setYear(1990);
		System.out.println("change: " + t.getDate());

		Date d1 = t.getDateWrong();
		System.out.println("get wrong: " + d1);
		d1.setYear(1990);
		System.out.println("change: " + t.getDate());

		Date fd = t.getFd();
		System.out.println("fd: " + fd);
		
		fd.setYear(1990);
		System.out.println("fd: " + fd);
		System.out.println("get fd: " + t.getFd());
	}
}

class Test {
	
	final Date fd;
	
	Date getFd() {return fd;}
	
	private Date d;
	
	Test(Date d) {
		this.d = d;
		fd = new Date();
	}
	
	Date getDateWrong() {
		return d;
	}
	
	Date getDate() {
		return (Date)d.clone();
	}
}

