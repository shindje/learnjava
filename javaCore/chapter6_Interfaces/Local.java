package chapter6_Interfaces;

public class Local {

	int k = 3;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int j = 6;
		
		class InnerLocal {
			int getInt () {
				//return k;	//No Access to outer class
				return 5 + j;	//Has access only to final loval var
			}
		}
		
		System.out.println((new InnerLocal()).getInt());
		System.out.println((new InnerLocal()).getClass());
		System.out.println((new InnerLocal()).getClass().getEnclosingClass());
	}

}
