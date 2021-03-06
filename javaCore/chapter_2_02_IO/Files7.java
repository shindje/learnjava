package chapter_2_02_IO;

import java.nio.file.Files;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.*;
import static chapter_2_01_Java8_Streams.Streams.prints;

public class Files7 {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("txtfile");
		byte[] bytes = Files.readAllBytes(p);

		System.out.println("for small files:");
		System.out.println("read as bytes:");
		System.out.println(bytes);
		String s = new String(bytes);
		System.out.println("\nread as string:");
		System.out.println(s);
		System.out.println("\nread as lines:");
		System.out.println(Files.readAllLines(p));
//		Files.write(p, "\nFiles.write() added".getBytes(), StandardOpenOption.APPEND);
		System.out.println("\nread as string2:");
		System.out.println(new String(Files.readAllBytes(p)));
		
		System.out.println("\nfor big files use: Reader in = Files.newInputStream, Writer out = Files.newOutputStream");
		
		System.out.println("\ncreate temp file: " + Files.createTempFile(null, ".txt"));
		
		try (Stream<String> ss = Files.lines(p)) {
			prints("\nread to stream (length > 15): ", ss.filter(l -> l.length() > 15));
		}
		

	}
}
