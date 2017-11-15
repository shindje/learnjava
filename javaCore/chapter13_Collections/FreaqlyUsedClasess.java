package chapter13_Collections;

import java.util.*;

public class FreaqlyUsedClasess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("b");
		pq.add("c");
		pq.add("a");
		
		pq.peek();
		pq.remove();
		System.out.println("PriorityQueue :" + pq);
		
		WeakHashMap whm = new WeakHashMap();
		IdentityHashMap ihm  = new IdentityHashMap();	//compare by == instead of equals()
		
		LinkedList<String> ll = new LinkedList<>();
		ll.add("first");
		ll.add("second");
		ll.add("third");
		ListIterator li = ll.listIterator();
		li.next();
		System.out.println("ll.nextIndex(): " + li.nextIndex());
		li.next();
		li.set("updated second");
		li.previous();
		li.add("before second");
		System.out.println("LinkedList: " + ll);
	}

}
