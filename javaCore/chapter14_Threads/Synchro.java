package chapter14_Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synchro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		MyLong2 myL = new MyLong2();
		for (int i = 1; i<=1000; i++) {
			if (i%500 == 0)
				(new Thread(new MyRunSync(myL, true))).start();
			else
				(new Thread(new MyRunSync(myL, false))).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("with synchro. l = " + myL.l);
	}
}
	
class MyRunSync implements Runnable {
	MyLong2 l;
	boolean unlocker;
	
	public MyRunSync(MyLong2 l, boolean unlocker) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.unlocker = unlocker;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		l.someDo(unlocker);
	}
}

class MyLong2 {
	public long l = 0;
	
	public synchronized void someDo(boolean unlocker) {	//use intrinsicLock
		try {
			for (int i = 1; i<1000; i ++) {
				for (int j = 1; j<10; j++) {
					if (j == 5 && i == 400 && !unlocker) {
						System.out.println(Thread.currentThread().getId() + " waiting");
						wait();	//use internal condition
					}

				}
				
				l = l + 5;
				l = l - 5;
				
			}
			//System.out.println(Thread.currentThread().getId() + " l = " + l.l);// + ". " + "i = " + i + ". l-i*5 = " + (l.l-i*5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			notify();	//might be not safe cause unblocked thread might not be unlock lock depends on check condition  
			//notifyAll();	//more safety
			System.out.println(Thread.currentThread().getId() + " notified");
		}
	}
}