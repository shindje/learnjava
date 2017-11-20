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
		pq.add("f");
		pq.add("a");
		pq.add("c");
		pq.add("d");
		pq.add("e");
		System.out.println("PriorityQueue :" + pq);
		pq.peek();
		pq.remove();
		System.out.println("PriorityQueue after remove min:" + pq);
		pq.remove();
		System.out.println("PriorityQueue after remove min2:" + pq);
		
		WeakHashMap whm = new WeakHashMap();
		IdentityHashMap ihm  = new IdentityHashMap();	//compare by == instead of equals(). Get hash by Object.hashCode()
		
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
		
		ArrayDeque<String> ad = new ArrayDeque();
		ad.add(" middle ");
		ad.addFirst(" first ");
		ad.addLast(" last ");
		System.out.println("ArrayDeque: " + ad);
		
		LinkedHashSet lhs = new LinkedHashSet<>();
		lhs.add("a");
		lhs.add("c");
		lhs.add("d");
		lhs.add("b");
		System.out.println("LinkedHashSet: " + lhs);

		LinkedHashMap lhm = new LinkedHashMap(4, 0.75F, true){	//true = use access order
		    @Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
		        return size() > 3;	//every time the eldest element will be removed if size > 3
		    }
		};
		lhm.put("3", "c");
		lhm.put("1", "a");
		lhm.put("4", "d");
		lhm.put("2", "b");
		System.out.println("LinkedHashMap: " + lhm);
		System.out.println("lhm.get(1): " + lhm.get("1"));
		System.out.println("LinkedHashMap after get 1: " + lhm);
		System.out.println("lhm.get(4): " + lhm.get("4"));
		System.out.println("LinkedHashMap after get 4: " + lhm);
		lhm.put("5", "e");
		System.out.println("LinkedHashMap after put 5: " + lhm);
		
		EnumSet<SomeEnum> acEnum = EnumSet.range(SomeEnum.A, SomeEnum.C);
		System.out.println("EnumSet from A to C: " + acEnum);
		
		EnumMap<SomeEnum, String> em = new EnumMap(SomeEnum.class);
		em.put(SomeEnum.C, "c");
		em.put(SomeEnum.A, "a");
		System.out.println("EnumMap: " + em);
		
		Stack stack = new Stack<>();
		stack.push("a");
		stack.push("b");
		System.out.println("Stack: " + stack);
		System.out.println("Stack.pop(): " + stack.pop());
		System.out.println("Stack.peek(): " + stack.peek());
		System.out.println("Stack.pop(): " + stack.pop());
		
		BitSet bitSet = new BitSet();
		bitSet.set(0, true);
		bitSet.set(1, false);
		bitSet.set(2, true);
		bitSet.set(3, false);
		System.out.println("BitSet (show only 'true' bits): " + bitSet);
		bitSet.set(3);
		System.out.println("BitSet after set 3: " + bitSet);
		BitSet bitSetForAnd = new BitSet();
		bitSetForAnd.set(2);
		bitSet.and(bitSetForAnd);
		System.out.println("BitSet and 001: " + bitSet);

	}

	enum SomeEnum {A, B, C, D};
}
