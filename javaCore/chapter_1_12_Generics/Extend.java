package chapter_1_12_Generics;

public class Extend {
	static <T extends Number> int getInt(T number) {
		return number.intValue();
	}

	public static void main(String ...strings ) {
		System.out.println(Extend.getInt(new Double(4.55)));
	}
	
}
