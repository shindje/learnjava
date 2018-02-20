package chapter_2_01_Java8_Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chapter_2_01_Java8_Streams.Streams.prints;

public class StreamMethods {
	
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(new Integer[]{4,5,7,-4,23,2,5,6});
		List<Integer> l2 = Arrays.asList(new Integer[]{43,12,55});
		System.out.print("iterator: ");
		Iterator l5Iterator = l.stream().limit(5).iterator();  
		while (l5Iterator.hasNext()) {
			System.out.print(l5Iterator.next() + ", ");
		}
		System.out.println();

		System.out.print("for Each: ");
		l.stream().limit(5).forEach(i -> System.out.print(i + ", "));
		System.out.println();
		
		System.out.println("to Array: " + Arrays.deepToString(l.stream().limit(5).toArray()));
		System.out.println("Collectors to List: " + l.stream().limit(5).collect(Collectors.toList()));
		System.out.println("Collectors joining: " + l.stream().limit(5).map(Object::toString).collect(Collectors.joining(", ")));
		System.out.println("Collectors summarizingInt getAverage: " + l.stream().limit(5).collect(Collectors.summarizingInt(i->i)).getAverage());
		prints("map(i+3) ", l.stream().map(i->i+3));
		prints("maps(i+3) ", l.stream().map(i->Stream.generate(()->i+3).limit(1)));		
		prints("flatmap(i+3) ", l.stream().flatMap(i->Stream.generate(()->i+3).limit(1)));
		prints("skip(2) ", l.stream().skip(2));
		prints("concat ", Stream.concat(l.stream(), l2.stream()));
		prints("distinct ", l.stream().distinct());
		prints("sorted ", l.stream().sorted());
		System.out.print("peek: ");
		prints("", l.stream().peek(i->System.out.print(i + " peeked, ")));

		System.out.println("max: " + l.stream().max(Comparator.naturalOrder()).orElse(-1));
		System.out.println("findFirst>5: " + l.stream().filter(i -> i>5).findFirst().orElse(-1));
		System.out.println("findAny>5: " + l.stream().filter(i -> i>5).findAny().orElse(-1));
		System.out.println("anyMatch>5: " + l.stream().anyMatch(i -> i>5));
		System.out.println("allMatch>5: " + l.stream().allMatch(i -> i>5));
		System.out.println("noneMatch>5: " + l.stream().noneMatch(i -> i>5));

		System.out.print("Optional.ifPresent - findAny>5 + 3: ");
		l.stream().filter(i -> i>5).findFirst().ifPresent(i -> System.out.println("consumed " + (i+3)));
		System.out.println("Optional.map - findAny>5 + 3: " + l.stream().filter(i -> i>5).findFirst().map(i -> i+3));
		System.out.println("Optional.flatMap. findFirst>5: " + l.stream().filter(i -> i>5).findFirst().flatMap(StreamMethods::toOptionalString));	
	}
	
	static Optional<String> toOptionalString(Integer i) {
		return Optional.of("flatmapped " + i);
	}

}
