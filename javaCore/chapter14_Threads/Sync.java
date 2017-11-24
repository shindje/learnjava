package chapter14_Threads;

public class Sync {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLong myL = new MyLong();
		(new Thread(new MyRunSync(myL))).start();
		(new Thread(new MyRunSync(myL))).start();
		//(new Thread(new MyRunSync(myL))).start();
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
			l.l = l.l + 5;
			System.out.println(Thread.currentThread().getId() + " l = " + l.l + ". " + "i = " + i + ". l-i*5 = " + (l.l-i*5));
		}
	}
	
}

class MyLong {
	public long l = 0;	
}
