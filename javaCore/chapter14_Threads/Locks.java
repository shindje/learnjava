package chapter14_Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLong myL = new MyLong();
		myL.useLock = false;
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
		System.out.println("with no lock. l = " + myL.l);
		myL.l = 0;
		myL.useLock = true;
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
		System.out.println("with lock. l = " + myL.l);
	}
}

class MyRunSync implements Runnable {
	MyLong l;
	boolean unlocker;
	
	public MyRunSync(MyLong l, boolean unlocker) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.unlocker = unlocker;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (l.useLock)
			l.lock.lock();
		try{
			for (int i = 1; i<1000; i ++) {
				for (int j = 1; j<10; j++) {
					if (l.useLock)	{	//second lock
						l.lock.lock();
						if (j == 5 && i == 400 && !unlocker) {
							System.out.println(Thread.currentThread().getId() + " awaiting");
							l.biggerThenFive.await();
						}

					}
					
					l.l = l.l + 5;
					l.l = l.l - 5;
					
					if (l.useLock)	//second unlock
						l.lock.unlock();
				}
				//System.out.println(Thread.currentThread().getId() + " l = " + l.l);// + ". " + "i = " + i + ". l-i*5 = " + (l.l-i*5));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (l.useLock) {
				l.biggerThenFive.signal();	//might be not safe cause unblocked thread might not be unlock lock depends on check condition  
				//l.biggerThenFive.signalAll();	//more safety
				l.lock.unlock();
				System.out.println(Thread.currentThread().getId() + " signaled");
			}
		}

	}
	
}

class MyLong {
	public boolean useLock;
	public long l = 0;
	public Lock lock = new ReentrantLock();
	public Condition biggerThenFive = lock.newCondition();
}
