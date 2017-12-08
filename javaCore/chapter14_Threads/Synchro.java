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
				(new Thread(new MyRunSyncMethod(myL, true))).start();
			else
				(new Thread(new MyRunSyncMethod(myL, false))).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("with synchro method. l = " + myL.l);
		
		for (int i = 1; i<=1000; i++) {
			if (i%500 == 0)
				(new Thread(new MyRunSyncBlock(myL, true))).start();
			else
				(new Thread(new MyRunSyncBlock(myL, false))).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("with synchro block. l = " + myL.l);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("volatile create 50 get");
		for (int i = 1; i<=50; i++)
			(new Thread(new MyRunVolatileGet(myL))).start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("volatile create 1 set");
		(new Thread(new MyRunVolatileSet(myL))).start();
	
	}
}
	
class MyRunSyncMethod implements Runnable {
	MyLong2 l;
	boolean unlocker;
	
	public MyRunSyncMethod(MyLong2 l, boolean unlocker) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.unlocker = unlocker;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		l.someDoSynchroMethod(unlocker);
	}
}

class MyRunSyncBlock implements Runnable {
	MyLong2 l;
	
	public MyRunSyncBlock(MyLong2 l, boolean unlocker) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		l.someDoSynchroBlock();
	}
}

class MyRunVolatileGet implements Runnable {
	MyLong2 l;
	
	public MyRunVolatileGet(MyLong2 l) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		long i = 0;
		while (l.volatileGet() == 0 && i<1000000000) {
			i++;
		}
		System.out.println(" i=" + i);
	}
}

class MyRunVolatileSet implements Runnable {
	MyLong2 l;
	
	public MyRunVolatileSet(MyLong2 l) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		l.volatileSet(1);
	}
}



class MyLong2 {
	public long l = 0;
	Object lockObject = new Object();
	public volatile long vol = 0;
	
	public synchronized void someDoSynchroMethod(boolean unlocker) {	//use intrinsicLock
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
			//notify();	//might be not safe cause unblocked thread might not be unlock lock depends on check condition  
			notifyAll();	//more safety
			System.out.println(Thread.currentThread().getId() + " notified");
		}
	}
	
	public void someDoSynchroBlock() {	//use intrinsicLock
		for (int i = 1; i<1000; i ++) {
			for (int j = 1; j<10; j++) {
				synchronized (lockObject) {
					l = l + 5;
					l = l - 5;
				}
			}
		}
	}
	
	public void volatileSet(long al) {
		vol = al;
	}
	
	public long volatileGet() {
		return vol;
	}

}