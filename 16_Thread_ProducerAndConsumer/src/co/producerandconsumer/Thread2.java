package co.producerandconsumer;

import java.util.concurrent.BlockingQueue;

public class Thread2 extends Thread {

	BlockingQueue<Integer> q=null;
	
	public Thread2(BlockingQueue<Integer> q) {
		this.q=q;
	}
	
	@Override
	public void run() {

		System.out.println("Thread2.run()");
		
		try {
			System.out.println(q.take()); // delete the 0th element from the q.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
