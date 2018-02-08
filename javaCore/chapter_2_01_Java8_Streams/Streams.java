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
		prints("Math::random: ", Stream.generate(Math::random), 4);
		Random intRandom = new Random();
		prints("intRandom: ", Stream.generate(intRandom::nextInt), 4);
		prints("Stream.iterate: ", Stream.iterate(BigInteger.valueOf(5), i->i.add(BigInteger.valueOf(3))).limit(4));
		prints("Arrays.stream (from 3rd to 7th): ", Arrays.stream(new Integer[]{3,5,2,5,7,3,1,4,3,6}, 3, 7));
		
		prints("map(i+3) ", l.stream().map(i->i+3));
		prints("maps(i+3) ", l.stream().map(i->Stream.generate(()->i+3).limit(1)));
		prints("flatmap(i+3) ", l.stream().flatMap(i->Stream.generate(()->i+3).limit(1)));
		
	}

	static void prints(String ss, Stream s) {
		System.out.println(ss + s.collect(Collectors.toList()));
	}

	static void prints(String ss, Stream s, int limit) {
		prints(ss, s.limit(limit));
	}
}

