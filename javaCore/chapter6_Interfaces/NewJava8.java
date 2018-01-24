package chapter6_Interfaces;

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
	}

	static String getStrFromLambda(Lambda l) {
		return l.getStrLambda();
	}
	
	static void doSomeLambda(LambdaVoid lv) {
		lv.doLambda();
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