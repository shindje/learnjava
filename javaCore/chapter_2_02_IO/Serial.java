package chapter_2_02_IO;

import java.beans.Transient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serial {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MyClass m1 = new MyClass();
		m1.s = "m1";
		m1.i = 3;
		m1.s2 = "ss2";
		
		MyClass son = new MyClass();
		son.s = "son1";
		
		m1.son = son;
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objects"));
			oos.writeObject(m1);
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objects"));
			System.out.println("got: " + ois.readObject());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class MyClass implements Serializable {
	String s;
	int i;
	
	transient String s2;
	
	MyClass son;
	
	@Override
	public String toString() {
		return "MyClass: " + s + " " + i + " s2: " + s2 + ". Son: [" + son + "]";
	};
}

