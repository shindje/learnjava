package chapter6_Interfaces;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Clone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.Timer t = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.print(" _");
				Toolkit.getDefaultToolkit().beep();
			}
		});
		
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.out.println("");
			// TODO Auto-generated method stub
		Clone c = new Clone();
		try {
			c.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Clone2 c2 = new Clone2();
		//c2.clone();
		c2.getInt();
		c2.getIntProtect();
		
		Prot2 p2 = new Prot2();
		//p2.getProt(); //Protected is not visible from another package
		//p2.getPackage();	//Package is not visible from another package
		
		int[] arr = new  int[3];
		arr[2] = 34;
		
		int[] arr2 = arr.clone();
		System.out.println("arr2[2] = " + arr2[2]);
	}

}


class Prot2Extends extends Prot2 {
	void get() {
		getProt();	//Protected is visble
		//getPackage();	//Package is not visible
		
		Prot2Extends2 p2 = new Prot2Extends2();
		//p2.getProt();	//Protected other Class is not visble
		//p2.getPackage();	//Package other Class is not visible
		
		Prot2 pr2 = new Prot2();
		//pr2.getProt(); //Protected other Object of Superclass is not visble
		
		Prot2Extends p3 = new Prot2Extends();
		p3.getProt();	//Protected other Object is visble
		//p3.getPackage();	//Package other Object is not visible
		
	}
}

class Prot2Extends2 extends Prot2 {}


class Clone2 {

	int getInt(){
		return 1;
	}
	
	protected int getIntProtect() {
		return 2;
	}
}