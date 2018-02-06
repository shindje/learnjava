package chapter_1_03_MainJavaConstructions;
public class Operations {

	public static void main(String ... s) {
		System.out.println(-25>>1);	//-13
		System.out.println(-25>>>1);	//2147483635
		System.out.println(25>>1);	//12
		System.out.println(25>>>1);	//12

		System.out.println(Math.pow(3, 2));	//9
		System.out.println(Math.sqrt(Math.PI));
		System.out.println(StrictMath.sqrt(StrictMath.PI));

		int n = 1234567890;
		float f = n;
		double d = n;
		System.out.println("int(" + n + ") -> float = " + f + ". BAD");
		System.out.println("int(" + n + ") -> double = " + d + ". GOOD");
		
		long l = 1234567890123456789L;
		f = l;
		d = l;
		System.out.println("long(" + l + ") -> float = " + f + ". BAD");
		System.out.println("long(" + l + ") -> double = " + d + ". BAD");
		
		System.out.println("int(3.54) = " + (int)3.54);
		System.out.println("round(3.54) = " + Math.round(3.54));

	}
}
