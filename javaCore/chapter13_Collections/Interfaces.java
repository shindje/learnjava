package chapter13_Collections;

import java.util.*;

public class Interfaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection c = new ArrayList();
		c.size();
		c.add("dd");
		c.add("ff");
		c.add("ee");
		Iterator i = c.iterator();
		boolean f = false;
		while (i.hasNext()) {
			Object o = i.next();
			System.out.println(o);
			if (!f)
				i.remove();
			f=true;
		}
		System.out.println("--");
		c.remove("ff");
		for (Object o: c)
			System.out.println(o);
	}

}
