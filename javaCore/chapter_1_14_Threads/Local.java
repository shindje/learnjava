package chapter_1_14_Threads;

import java.util.concurrent.ThreadLocalRandom;

public class Local {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RunLong rl = new RunLong();
		rl.l = 1100l;
		
		for (int i=0; i<1000; i++)
			new Thread(rl).start();
		
		Thread.sleep(500);
		System.out.println();
		System.out.println(rl.l);
	}

}

class RunLong implements Runnable {
	static Long l;
	static ThreadLocal<Long> ll = new ThreadLocal<Long>(){
		protected Long initialValue() {
			return 1100l;
		}
	};
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("<"+ll.get());
		ll.set(ll.get()+1);
		System.out.print("-"+ll.get()+">");
		System.out.print("[rnd: "+ThreadLocalRandom.current().nextInt(50)+"]");
	}
}
