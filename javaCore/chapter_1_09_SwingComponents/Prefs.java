package chapter_1_09_SwingComponents;

import java.util.prefs.Preferences;

public class Prefs {
	
	public static void main(String[] args) {
		Preferences p = Preferences.userRoot();
		Preferences node = p.node("/java/learn/sample");
		//node.putInt("int_sample", 4);	//putted
		int i = node.getInt("int_sample", -1);
		System.out.println("i: " + i);
	}

}
