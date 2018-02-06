package chapter_1_03_MainJavaConstructions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;


public class IO3_files {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter w = new PrintWriter("somefile");
		w.print(true);
		w.print("str");
		w.print(2);
		w.close();
		
		File f = new File("somefile");
		if (f.exists()) {
			Scanner s = new Scanner (f);
			if (s.hasNext())
				System.out.println(s.next());	//truestr2
			s.close();
		}
	}

}
