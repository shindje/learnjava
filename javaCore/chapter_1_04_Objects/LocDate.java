package chapter4_Objects;

import java.time.LocalDate;

public class LocDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate ldNow = LocalDate.now();
		System.out.println(ldNow);

		LocalDate ld = LocalDate.of(2017,2,22);
		System.out.println(ld);

		LocalDate ldPlus10 = ld.plusDays(10);
		System.out.println(ldPlus10);

	}

}
