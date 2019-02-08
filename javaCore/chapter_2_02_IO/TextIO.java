package chapter_2_02_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextIO {

	
	public static void main(String [] ss) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("txtfile");
		pw.write("write string. ");
		pw.print("print string. ");
		pw.println();
		pw.write("write 45: ");
		pw.write(45);
		pw.println();
		pw.write("print 45: ");
		pw.print(45);
		pw.println();
		pw.write(new Integer(47).toString());
		pw.write("end");
		pw.close();
		
		Scanner s = new Scanner(new File("txtfile"));
		System.out.println("Scanner read: " + s.nextLine());
		
	}
	
}
