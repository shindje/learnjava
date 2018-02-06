package chapter_1_13_Collections;

import java.util.*;

public class Tools {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = Arrays.asList("4", "6", "v");
		System.out.println("Arrays.asList: " + strings);
		System.out.println("Arrays.asList.1: " + strings.get(1));
		strings.set(1, "5");
		System.out.println("Arrays.asList.1 edited: " + strings.get(1));
		try {
			strings.add(1, "55");
		} catch (UnsupportedOperationException e) {
			System.out.println("Arrays.asList add: UnsupportedOperationException");
		}
		
		List copy3a = Collections.nCopies(3, "a");
		System.out.println("Collections.nCopies: " + copy3a);
		try {
			copy3a.set(1, "b");
		} catch (UnsupportedOperationException e) {
			System.out.println("Collections.nCopies set: UnsupportedOperationException");
		}

		Set single = Collections.singleton("a");
		System.out.println("Collections.singleton: " + single);
		try {
			single.add("d");
		} catch (UnsupportedOperationException e) {
			System.out.println("Collections.singleton set: UnsupportedOperationException");
		}
		
		List subStrings = strings.subList(0, 2);
		System.out.println("List.subList: " + subStrings);
		ListIterator i = subStrings.listIterator();
		i.next();
		i.set("3");
		System.out.println("List after modify subList: " + strings);
		
		List unmodify = Collections.unmodifiableList(strings);
		try {
			unmodify.add("d");
		} catch (UnsupportedOperationException e) {
			System.out.println("Collections.unmodifiableList add: UnsupportedOperationException");
		}

		System.out.println("Collections.synchronizedList: " + Collections.synchronizedList(strings));

		List dateToStrings = Collections.checkedList(strings, String.class);
		try {
			dateToStrings.add(new Date());
		} catch (ClassCastException e) {
			System.out.println("Collections.checkedList add Date: ClassCastException");
		}
		
		ArrayList ar1 = new ArrayList<>();
		ar1.add("2");
		ar1.add("4");
		ar1.add("55");
		ar1.add("6");
		ArrayList ar2 = new ArrayList<>();
		ar2.add("3");
		ar2.add("6");
		ar2.add("2");
		ar1.retainAll(ar2);
		System.out.println("ar1.retainAll(ar2): " + ar1);

		Collections.sort(ar2);
		System.out.println("Collections.sort(ar2): " + ar2);
		Collections.sort(ar2, Collections.reverseOrder());
		System.out.println("Collections.sort(ar2) by reverseOrder: " + ar2);
		ar2.add("5");
		ar2.add("7");
		ar2.add("1");
		Collections.shuffle(ar2);
		System.out.println("Collections.shuffle: " + ar2);
		
		Collections.sort(ar2);
		System.out.println("Collections.sort(ar2): " + ar2);
		System.out.println("Collections.binarySearch('3'): " + Collections.binarySearch(ar2, "3"));
		System.out.println("Collections.binarySearch('4'): " + Collections.binarySearch(ar2, "4") + ". should be inserted in " + (-Collections.binarySearch(ar2, "4") -1) + " position");

	}

}
