package chapter_1_06_Interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class NewJava8 implements IFace{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IFace.getStr());
		
		NewJava8 obj = new NewJava8();
		System.out.println(obj.getStrDefault());
		
		Lambda lObj = () -> "lambda object return";
		System.out.println(lObj.getStrLambda());
		
		System.out.println(getStrFromLambda(()->"lambda string with no object"));

		doSomeLambda(()->{
			System.out.println("do lambda 1"); 
			System.out.println("do lambda 2");
		});
		
		System.out.println(useBiFunctionWithAandB((a, b) -> a + " " + b));
		
		String[] ss= {"vf", "avsvs", "F"};
		Arrays.sort(ss, (a,b)->a.length()-b.length());
		System.out.println(Arrays.toString(ss));

		Arrays.sort(ss, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(ss));
		
		List<String> ssList = Arrays.asList(ss);
		Stream<String> ssStream = ssList.stream();
		String[] ssFromStream = ssStream.toArray(String[]::new);
		System.out.println("ssFromStream: " + Arrays.toString(ssFromStream));
		
		
		ssList.sort(Comparator.comparingInt(s -> s.length()));
		System.out.println("ssList sort by length: " + ssList);
		
		
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "one");
		map.put(3, "three");
		map.put(5, "five");
		System.out.println("search map for value.lentgh=4: " + map.searchValues(5, v -> v.length()==4?v:null));
		System.out.println("reduce all values.length>3: " + map.reduce(5, (k, v) -> v.length()>3? v+ " ": null, String::concat));
	}

	static String getStrFromLambda(Lambda l) {
		return l.getStrLambda();
	}
	
	static void doSomeLambda(LambdaVoid lv) {
		lv.doLambda();
	}
	
	static String useBiFunctionWithAandB(BiFunction<String, String, String> f) {
		return f.apply("A", "B");
	}
}

interface IFace {
	public static String getStr() {
		return "String from Interface";
	}
	
	default String getStrDefault() {
		return "Defaule string from Interface";
	}	
}

interface Lambda {
	String getStrLambda();
}

interface LambdaVoid {
	void doLambda();
}