package chapter6_Interfaces;

public class GoodClone implements Cloneable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public /*!!! PUBLIC IS BETTER*/ GoodClone clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (GoodClone)super.clone();
	}

}
