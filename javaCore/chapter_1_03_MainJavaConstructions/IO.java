package chapter3_MainJavaConstructions;
import java.io.Console;
import java.util.Scanner;


public class IO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter string: ");
		String ss = scan.nextLine();
		System.out.println("Entered: " + ss);
		
		System.out.print("Enter words: ");
		String s = scan.next();
		System.out.println("Entered: " + s);
		
		System.out.print("Enter number: ");
		int i = scan.nextInt();
		System.out.println("Entered: " + i);
		
		/*??? cons == null
		Console cons = System.console();
		String name = cons.readLine();
		char[] pwd = cons.readPassword();
		System.out.println("Entered: name: " + name + " pwd: " + pwd);
		*/
	}

}
