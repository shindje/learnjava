package chapter_1_03_MainJavaConstructions;
import java.math.BigDecimal;

public class BIG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal d = new BigDecimal(1);
		//System.out.print(d > 0);
		
		 String newId = "4e23";
		 newId = newId.replaceAll("\\D", "+");
		 System.out.print(newId);
			
	}

}
