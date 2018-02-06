package chapter_1_12_Generics;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.math.BigInteger;
import java.util.Arrays;

public class Wildcards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Some<Integer> someInteger = new Some<Integer>();
		someInteger.setF(new Integer(5));
		System.out.println("someNumber.f: " + someInteger.getF());
		
		Some<? extends Number> anyExtendsNumber = someInteger;
		System.out.println("anyExtendsNumber.f: " + anyExtendsNumber.getF());	//getF can return f as Number
		//anyExtendsNumber.setF(new Integer(4));	//compilation error
		//anyExtendsNumber = new Some<String>();	//compilation error
		
		Some<Number> someNumber = new Some<Number>();
		someNumber.setF(new Integer(6));
		System.out.println("someNumber.f: " + someNumber.getF());
		
		Some<? super Integer> anySuperInteger = someNumber;
		anySuperInteger.setF(new Integer(7));
		//anySuperInteger = new Some<String>();	//compilation error
		System.out.println("anySuperInteger.f: " + anySuperInteger.getF());	//getF can return f as Object
		
		Some<?> anySome = someInteger;
		System.out.println("anySome.f: " + anySome.getF());	//getF can return f as Object
		//anySome.setF(new Integer(1));	//compilation error

		catchWildCard(anySome);
		
		String s = "str";
		Class<String> cs = (Class<String>)s.getClass();
		try {
			String s2 = cs.newInstance();
			System.out.println("s2: " + s2);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TypeVariable[] typeParams = someInteger.getClass().getTypeParameters();
		System.out.println("typeParams: " + Arrays.toString(typeParams));
		System.out.println("typeParams.0: " + typeParams[0].getTypeName());

		try {
			Method m = Wildcards.class.getMethod("catchWildCardGeneric", Some.class);
			TypeVariable[] typeMethodParams = m.getTypeParameters();
			System.out.println("typeParams in Method: " + Arrays.toString(typeMethodParams));
		} catch (SecurityException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void catchWildCard(Some<?> some) {
		//? f = some.getF();	//can't create a var
		catchWildCardGeneric(some);
	}
	
	public static <T> void catchWildCardGeneric (Some<T> some) {
		T f = some.getF();	//can create a var
		System.out.println("f catched type: " + f);
	}
}

class Some<T> {
	T f;
	T getF() {
		return f;
	}
	void setF(T f) {
		this.f = f;
	}
}