package chapter_2_01_Java8_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static chapter_2_01_Java8_Streams.Streams.prints;

public class Parallel {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(new Integer[]{4,5,7,-4,23,2,5,6});
		prints("Collection.parallelStream: ", l.parallelStream());
		prints("Stream.parallel: ", l.stream().parallel());
		System.out.println("parallel groupBy(i>4) count: " + l.parallelStream().collect(Collectors.groupingBy(i -> (i>4), Collectors.counting())));
		prints("Collection.parallelStream.unordered: ", l.parallelStream().unordered().limit(4));
	}
	
}
