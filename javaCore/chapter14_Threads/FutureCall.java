package chapter14_Threads;

import java.util.concurrent.*;

public class FutureCall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Callable myCall = new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				// TODO Auto-generated method stub
				return "some thing";
			}
		};
		
		FutureTask task =  new FutureTask(myCall);
		Thread t = new Thread(task);
		t.start();
		
		try {
			System.out.println("get future: " + task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 ExecutorService pool = Executors.newCachedThreadPool();
		 Future f = pool.submit(task);
		 try {
			 System.out.println("get future from pool: " + f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pool.shutdown();
	}

}
