package chapter_1_04_Objects;

import java.util.Objects;

public class Super2 extends Super {

	Super2(){
		super(3);
	}
	
	int getPPP() {
		return getPP();
	}
	
	/*	Method Super.getPP() is not visible!!!
	int getPPP2(Super s) {
		return s.getPP();
	}
	*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super2 s2 = new Super2();
		System.out.println(s2.getPPP());
		
		System.out.println(Objects.equals(new String("aaa"), new String("aaa")));
	}

}
