package chapter14_Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sync {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLong myL = new MyLong();
		myL.lock = new ReentrantLock();
		myL.useLock = false;
		for (int i = 1; i<1000; i++) {
			(new Thread(new MyRunSync(myL))).start();
		}
		System.out.println("with no lock. l = " + myL.l);
		myL.l = 0;
		myL.useLock = true;
		for (int i = 1; i<1000; i++) {
			(new Thread(new MyRunSync(myL))).start();
		}
		System.out.println("with lock. l = " + myL.l);
	}
}

class MyRunSync implements Runnable {
	MyLong l;
	
	public MyRunSync(MyLong l) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i<1000; i ++) {
			if (l.useLock)
				l.lock.lock();
			try{
				for (int j = 1; j<10; j++) {
					l.l = l.l + 5;
					l.l = l.l - 5;
				}
				//System.out.println(Thread.currentThread().getId() + " l = " + l.l);// + ". " + "i = " + i + ". l-i*5 = " + (l.l-i*5));
			} finally {
				if (l.useLock)
					l.lock.unlock();
			}
		}
	}
	
}

class MyLong {
	public boolean useLock;
	public long l = 0;
	public Lock lock;
}
