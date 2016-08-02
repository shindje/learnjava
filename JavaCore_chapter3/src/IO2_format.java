import java.util.Date;


public class IO2_format {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%8.1f %4.2f", 22.46, 22.46);	//rounded: 22,5
		
		System.out.println();
		System.out.printf("%x", 27);	//1b
		
		System.out.println();
		System.out.printf("%e", 2.32);	//2,320000e+00

		System.out.println();
		System.out.printf("%g", 2.32);	//2,32000

		System.out.println();
		System.out.printf("%a", 2.32);	//0x1.28f5c28f5c28fp1

		System.out.println();
		System.out.printf("%s", 2.32);	//2.32

		System.out.println();
		System.out.printf("%c %b %h %n%%", 101, true, 33434);	//e true  829a /*hash code*/ \n %
		
		System.out.println();
		System.out.printf("%,0+20f", 232424f);	//+00000232а424,000000

		System.out.println();
		System.out.printf("% f% f", 232424f, -23232f);	// 232424,000000-23232,000000

		System.out.println();
		System.out.printf("%-6.2f", 1.4f);	// |1,40  |

		System.out.println();
		System.out.printf("%(f", -1.4f);	//(1,400000)

	
		System.out.println();
		System.out.printf("%#f", 131231.434343f);	//????
		
		System.out.println();
		System.out.printf("%1$f %2$d", 1.4d, 244);	//1,400000 244
		

		System.out.println();
		System.out.printf("%1$f %<a", 14.4);	//14,400000 0x1.ccccccccccccdp3
		
		System.out.println();
		String formatted = String.format("%1$f %<a", 14.4);
		System.out.printf(formatted);	//14,400000 0x1.ccccccccccccdp3
		
		
		System.out.println();
		System.out.printf("%tc seconds: %<ts millisecond: %<tQ ", new Date());	//╧э рту 01 18:12:31 EET 2016 seconds: 1470067951 millisecond: 1470067951173 
		

	}

}
