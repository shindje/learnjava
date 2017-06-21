package src;

public class Super extends SuperSuper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super s = new Super();
		s.setI(5);
		System.out.print(s.getI());
	}
	
	int getSupetI() {
		return super.getI();
	}

}

class SuperSuper {
	private int i = 0;
	
	int getI() {
		return i;
	}
	
	void setI(int ii) {
		i = ii;
	}
}
