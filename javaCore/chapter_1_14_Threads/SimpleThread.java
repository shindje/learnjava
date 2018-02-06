package chapter_1_14_Threads;

import java.io.EOFException;

public class SimpleThread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyRun(""));
		t1.start();
		t1.interrupt();
		(new Thread(new MyRun(""))).start();
		System.out.println();
		Thread t3 = new Thread(new MyRun(""));
		Thread.sleep(10);
		System.out.println("\nThread state after new(): " + t3.getState());
		t3.start();
		System.out.println("\nThread state after start(): " + t3.getState());
		Thread.sleep(100);

		
		System.out.println();
		Thread t6 = new Thread(new MyRun("uncaught"));
		t6.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());	// == Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		t6.start();
		
		
		Thread.sleep(100);		
		System.out.println("\n Next 2 is daemons");
		Thread t4 = new Thread(new MyRun("priority"));
		t4.setPriority(Thread.MIN_PRIORITY);
		t4.setDaemon(true);
		t4.start();
		Thread t5Max = new Thread(new MyRun("priority"));
		t5Max.setPriority(Thread.MAX_PRIORITY);
		t5Max.setDaemon(true);
		t5Max.start();		
	}
}

class MyRun implements Runnable{
	String name;
	
	public MyRun(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public void run() {
		try {
			for (int i = 1; i<500; i++) {
				System.out.print(Thread.currentThread().getId() + ".");
				if (!name.equals("")) {
					if (name.equals("priority"))
						System.out.print("PRT_" + Thread.currentThread().getPriority() + ".");
					else
						System.out.print(name + ".");
				}
				System.out.print(i + " ");
				
				if (i==200 && name.equals("uncaught"))
					throw new NullPointerException();
				Thread.sleep(0);	//There should be Thread.sleep() to interrupt
			}
		} catch (InterruptedException e) {
			System.out.print(Thread.currentThread().getId() + "." + "interrupted" + " ");
		} finally {
			System.out.print(Thread.currentThread().getId() + "." + "stopping" + " ");			
		}
	}
	
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.print("Thread " + t.getId() + " uncaught exception handled " + e.getClass().getName());			
	}
	
}
