package chapter_1_14_Threads;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(10);
		for (int i=0; i<10; i++) {
			if (i%2 == 0)
				(new Thread(new ReadRun(q))).start();
			else
				(new Thread(new WriteRun(q))).start();
		}
		
	}

}

class ReadRun implements Runnable {
	ArrayBlockingQueue q;
	
	ReadRun(ArrayBlockingQueue q) {
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i<10; i++) {
			try {
				System.out.print("<" + Thread.currentThread().getId() + " " + q.take() + ">");
			} catch (InterruptedException e) {
				
			}
		}
	}
}


class WriteRun implements Runnable {
	ArrayBlockingQueue q;
	
	WriteRun(ArrayBlockingQueue q) {
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i<10; i++) {
			try {
				System.out.print("[-" + Thread.currentThread().getId() + " put-]");
				q.put(Thread.currentThread().getId());
			} catch (InterruptedException e) {
				
			}
		}
	}
}