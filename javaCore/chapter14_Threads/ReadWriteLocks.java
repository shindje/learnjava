package chapter14_Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLong5 myL = new MyLong5();
		myL.l = 0;
		for (int i = 1; i<=1000; i++) {
			if (i%100 != 0)
				(new Thread(new MyRunReadLock(myL))).start();
			else
				(new Thread(new MyRunWriteLock(myL))).start();
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

class MyRunReadLock implements Runnable {
	MyLong5 l;
	
	public MyRunReadLock(MyLong5 l) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		l.lock.readLock().lock();
		for (int i = 1; i<10; i ++)
			for (int j = 1; j<10; j++)
				System.out.print("<" + Thread.currentThread().getId() + " read: " + l.l + ">");
		l.lock.readLock().unlock();
	}
	
}

class MyRunWriteLock implements Runnable {
	MyLong5 l;
	
	public MyRunWriteLock(MyLong5 l) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		l.lock.writeLock().lock();
		l.l = Thread.currentThread().getId();
		System.out.print("<" + Thread.currentThread().getId() + " write: " + l.l + ">");
		l.lock.writeLock().unlock();
	}
	
}

class MyLong5 {
	public long l = 0;
	public ReadWriteLock lock = new ReentrantReadWriteLock();
}
