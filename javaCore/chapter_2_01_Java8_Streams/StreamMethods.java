package chapter_2_01_Java8_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static chapter_2_01_Java8_Streams.Streams.prints;

public class StreamMethods {
	
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(new Integer[]{4,5,-4,23,2,5,6});
		List<Integer> l2 = Arrays.asList(new Integer[]{43,12,55});
		prints("map(i+3) ", l.stream().map(i->i+3));
		prints("maps(i+3) ", l.stream().map(i->Stream.generate(()->i+3).limit(1)));		
		prints("flatmap(i+3) ", l.stream().flatMap(i->Stream.generate(()->i+3).limit(1)));
		prints("skip(2) ", l.stream().skip(2));
		prints("concat ", Stream.concat(l.stream(), l2.stream()));
		prints("distinct ", l.stream().distinct());
		prints("sorted ", l.stream().sorted());
		System.out.print("peek: ");
		prints("", l.stream().peek(i->System.out.print(i + " ")));

	}

}
