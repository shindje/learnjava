package chapter14_Threads;

import java.util.concurrent.atomic.AtomicLong;

public class Atomic {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AtomicLong al1 =  new AtomicLong(0);
		AtomicRun ar = new AtomicRun();
		ar.a = al1;
		for (int i=0; i<0000; i++)
			new Thread(ar).start();
		Thread.sleep(500);
		System.out.println();
		System.out.println("AtomicLong: " + ar.a);


		Long l1 =  0l;
		LongRun lr = new LongRun();
		lr.a = l1;
		for (int i=0; i<10000; i++)
			new Thread(lr).start();
		Thread.sleep(500);
		System.out.println();
		System.out.println("Long: " + lr.a);
	}
}

class LongRun implements Runnable {
	Long a;
	
	public void run() {
		if (Thread.currentThread().getId() % 2 == 0)
			System.out.print(" " + a++);
		else
			System.out.print(" " + a--);
	}
}

class AtomicRun implements Runnable {
	AtomicLong a;
	
	public void run() {
		if (Thread.currentThread().getId() % 2 == 0)
			System.out.print(" " + a.incrementAndGet());
		else
			System.out.print(" " + a.decrementAndGet());
	}
}