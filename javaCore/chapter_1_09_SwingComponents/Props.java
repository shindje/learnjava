package chapter9_SwingComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties p =  new Properties();
		p.put("1", "11");
		p.put("3", "333");
		
		try {
			FileOutputStream out = new FileOutputStream("props");
			String userDir = System.getProperty("user.home", "");
			p.store(out, "sample");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties p2 = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("props");
			p2.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("p2.3 : " + p2.get("3"));
		System.out.println("p2.4 : " + p2.get("4"));
		
	}

}
