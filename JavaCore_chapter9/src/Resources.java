package src;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Resources {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = Resources.class.getResource("111.jpg");
		System.out.println("url: " + url);
		Image img = new ImageIcon(url).getImage();
		System.out.println("img: " + img);
		
		InputStream s = Resources.class.getResourceAsStream("11/txtres.txt");
		System.out.println("s: " + s);
		Scanner in = new Scanner(s);
		System.out.println("txt: " + in.next());
		
	}

}
