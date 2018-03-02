package chapter_2_01_Java8_Streams;

import java.math.*;
import java.util.*;
import java.util.stream.*;

public class Streams {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(new Integer[]{4,5,4,23,2,6});
		long lcount = l.stream().filter(i -> i>4).count();
		System.out.println(l.toString() + " count>4: " + lcount);
		long lcount2 = l.parallelStream().filter(i -> i>4).count();
		
		prints("Stream.of + filter>4: ", Stream.of(4,5,4,23,2,6).filter(i -> i>4));
		prints("Stream.generate: ",Stream.generate(()->"something").limit(5));
		prints("Math::random: ", Stream.generate(Math::random).limit(4));
		Random intRandom = new Random();
		prints("intRandom: ", Stream.generate(intRandom::nextInt).limit(4));
		prints("Stream.iterate: ", Stream.iterate(BigInteger.valueOf(5), i->i.add(BigInteger.valueOf(3))).limit(4));
		prints("Arrays.stream (from 3rd to 7th): ", Arrays.stream(new Integer[]{3,5,2,5,7,3,1,4,3,6}, 3, 7));
		
		prints("IntStream.of: ", IntStream.of(2,5,2,5,6));
		prints("IntStream.range: ", IntStream.range(1, 6));
		prints("IntStream.boxed: ", IntStream.range(1, 6).boxed());
		System.out.println("IntStream.sum: " + IntStream.range(1, 6).sum());
		prints("Random.IntStream: ", new Random().ints(5));
		
	}

	public static void prints(String ss, BaseStream s) {
		System.out.print(ss);
		Iterator iterator = s.iterator();
		boolean first = true;
		while (iterator.hasNext()) {
			System.out.print((first?"":", ") + iterator.next());
			first = false;
		}
		System.out.println();
	}

}

