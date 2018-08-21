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

		DataInputStream din = new DataInputStream(pbin);
		System.out.println(din.readInt());
		
		PrintWriter pw = new PrintWriter("txtfile");
		pw.write("string one");
		pw.write(45);
		pw.write(new Integer(45).toString());
		pw.write("end");
		pw.close();
	}

}
