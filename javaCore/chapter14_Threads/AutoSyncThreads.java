package chapter14_Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class AutoSyncThreads {

	/** test win10 eclipse test updatre 444 555
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier b = new CyclicBarrier(3);
		for (int i=0; i<3; i++)
			new Thread(new BarrierRun(b)).start();
	}

}

class BarrierRun implements Runnable {
	
	CyclicBarrier barrier;
	
	public BarrierRun(CyclicBarrier barrier) {
		// TODO Auto-generated constructor stub
		this.barrier = barrier;
	}
	
	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getId());
			Thread.sleep(Thread.currentThread().getId() * 100);
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getId() + " to finish");
	}
}
