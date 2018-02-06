package chapter_1_14_Threads;

public class Volatile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLong3 myL = new MyLong3();
		
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

class MyRunVolatileGet implements Runnable {
	MyLong3 l;
	
	public MyRunVolatileGet(MyLong3 l) {
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
	MyLong3 l;
	
	public MyRunVolatileSet(MyLong3 l) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		l.volatileSet(1);
	}
}


class MyLong3 {
	public volatile long vol = 0;
	
	public void volatileSet(long al) {
		vol = al;
	}
	
	public long volatileGet() {
		return vol;
	}
}

