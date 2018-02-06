package chapter_1_14_Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLong4 myL = new MyLong4();
		myL.l = 0;
		for (int i = 1; i<=1000; i++) {
			if (i%500 == 0)
				(new Thread(new MyRunTryLock(myL, true))).start();
			else
				(new Thread(new MyRunTryLock(myL, false))).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("with try lock. l = " + myL.l);
	}
}

class MyRunTryLock implements Runnable {
	MyLong4 l;
	boolean unlocker;
	
	public MyRunTryLock(MyLong4 l, boolean unlocker) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.unlocker = unlocker;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if (l.lock.tryLock(10, TimeUnit.MILLISECONDS)) {
				for (int i = 1; i<1000; i ++) {
					for (int j = 1; j<10; j++) {
						if (j == 5 && i == 400 && !unlocker) {
							System.out.println(Thread.currentThread().getId() + " try awaiting");
							try {
								if (l.biggerThenFive.await(10, TimeUnit.MILLISECONDS))
									System.out.println(Thread.currentThread().getId() + " waited true");
								else
									System.out.println(Thread.currentThread().getId() + " waited false");
							} catch (InterruptedException e) {
								System.out.println(Thread.currentThread().getId() + " interrupted while awaiting");
							}
						}
					}
						
					l.l = l.l + 5;
					l.l = l.l - 5;
				}
				l.biggerThenFive.signal();	//might be not safe cause unblocked thread might not be unlock lock depends on check condition  
				l.lock.unlock();
				System.out.println(Thread.currentThread().getId() + " unlocked");
			} else
				System.out.println(Thread.currentThread().getId() + " lock failed");
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getId() + " interrupted while try lock");
		}
	}
}

class MyLong4 {
	public long l = 0;
	public Lock lock = new ReentrantLock();
	public Condition biggerThenFive = lock.newCondition();
}
