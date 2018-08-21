package chapter_2_02_IO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class Streams {

	public static void main(String[] args) throws IOException {
		DataOutputStream dout = new DataOutputStream(new FileOutputStream("intfile"));
		dout.writeInt(30);
		dout.writeInt(4);
		dout.close();
		
		System.out.println(System.getProperty("user.dir"));
		
		PushbackInputStream pbin = null;
		pbin = new PushbackInputStream(new BufferedInputStream(new FileInputStream("intfile")));

		DataInputStream din = new DataInputStream(pbin);
		System.out.println(din.readInt());
	}

}
