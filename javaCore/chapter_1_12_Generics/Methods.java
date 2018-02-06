package chapter_1_12_Generics;

import java.util.logging.Logger;

public class Methods {
	
	static <T> T getT(T t) {
		return t;
	}
	
	public static void main(String...a) {
		Logger.getGlobal().info(Methods.<String>getT("geg"));
	}

}
