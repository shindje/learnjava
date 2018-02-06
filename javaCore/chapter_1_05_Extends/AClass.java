package chapter5_Extends;

public class AClass {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		AClass a  = new AClass();
		System.out.println(a.getClass().getName());
		System.out.println(AClass.class.getName());
		System.out.println(int.class.getName());
		System.out.println(double[].class.getName());
		System.out.println("String instance: [" + String.class.newInstance() + "]");

	}

}
