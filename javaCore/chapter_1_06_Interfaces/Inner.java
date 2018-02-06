package chapter6_Interfaces;

public class Inner {

	private int i = 4;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inner i = new Inner();
		In in  = i.new In();
		System.out.println(in.getI());
		System.out.println(i.newIn().getOuterI());
		System.out.println((new Static()).getJ());
	}
	
	In newIn() {
		return new In();
	}

	class In {
		
		int i = 5;
		
		int getI () {
			return i;
		}
		
		int getOuterI () {
			return Inner.this.i;
		}
	}
	
	
	static class Static {
		int j = 7;
		
		int getJ(){
			return j;
		}
		
	}
	
}
