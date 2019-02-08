package chapter_2_02_IO;

import java.io.*;

public class Streams {

	public static void main(String[] args) throws IOException {
		DataOutputStream dout = new DataOutputStream(new FileOutputStream("intfile"));
		dout.writeInt(30);
		dout.writeInt(4);
		dout.close();
		
		System.out.println(System.getProperty("user.dir"));
		
		PushbackInputStream pbin = null;
		pbin = new PushbackInputStream(new BufferedInputStream(new FileInputStream("intfile")));

		int b = pbin.read();
		System.out.println("before (pushback): " + b);
		pbin.unread(b);
		System.out.println("returned");

		DataInputStream din = new DataInputStream(pbin);
		System.out.println(din.readInt());
	}

}
