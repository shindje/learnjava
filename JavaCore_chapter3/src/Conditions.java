import java.util.Arrays;


public class Conditions {
	enum Cases {one, two, three};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do
			System.out.println("hi");
		while (1<1);
	
		switch ("343") {
			case "3432":
				break;
			case "343":
				System.out.println("343");
		}
		
		switch (Cases.three) {
			case one:
				System.out.println(Cases.one);
			case three:
				System.out.println(Cases.three);	
			default:
				System.out.println("def");
		}
		
		for (int i = 1; i<10; i++) {
			System.out.println("start " + i);
			if (i > 3)
				break;
			System.out.println("end");
		}
		
		out: for (int i=1; i<10; i++) {
			System.out.println("out " + i);
			for (int j=1; j<10; j++) {
				System.out.println("in " + j);
				if (j>4)
					break out;
			}
		}
		
		out2: for (int i=1; i<10; i++) {
			System.out.println("2out " + i);
			for (int j=1; j<10; j++) {
				System.out.println("2in " + j);
				if (j>6)
					continue out2;
				if (j>4)
					continue;
				System.out.println("222in " + j);
			}
		}
		
		int[] a = {1,42,4};
		System.out.println(a.toString());
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		int [][] b = {{2,5,4}, {3,2}, {4}};
		System.out.println(Arrays.deepToString(b));

		int [][][] c = {{{2,5,4}, {3,2}, {4}}, {{3,3}, {1}, {4,53,2}}};
		System.out.println(Arrays.deepToString(c));
	}

}
