package src;

public class Super extends SuperSuper {
	
	Super(){
		super(7);
	}
	
	Super(int superJ) {
		super(superJ);
	}
	
	int j = 5;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super s = new Super(55);
		s.setI(5);
		System.out.println(s.getI());
		System.out.println(s.getJ());
		System.out.println(s.getSuperJ());
		
		s.s();
		
		SuperSuper ss = new Super(55);
		ss.s();
		
		SuperSuper [] ssArr = new SuperSuper[3];
		ssArr[1] = new SuperSuper(3);
		
		ssArr[2] = new Super(3);
		
		
		SuperSuper[] sArr = new Super[3];
		sArr[1] = new Super(3);
		
		//sArr[2] = new SuperSuper(3);	--ArrayStoreException
		
		

	}
	
	int getSupetI() {
		return super.getI();
	}
	
	int getJ(){
		return j;
	}
	
	int getSuperJ(){
		return super.j;
	}
	
	static void s(){
		System.out.println("Super");
	}
	

}

class SuperSuper {
	SuperSuper(int jj) {
		j = jj;
	}
	
	static void s(){
		System.out.println("SuperSuper");
	}
	
	private int i = 0;
	int j = 0;
	
	int getI() {
		return i;
	}
	
	void setI(int ii) {
		i = ii;
	}
}
