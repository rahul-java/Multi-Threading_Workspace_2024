package co.producerandconsumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumer {

	public static void main(String[] args) {
		
		/*Queue q=new ArrayBlockingQueue<>(3);
		q.add(10);
		q.add(20);
		q.add(30);
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());*/
		
		BlockingQueue q=new ArrayBlockingQueue<>(3);
		Thread1 t1=new Thread1(q);
		Thread2 t2=new Thread2(q);
		t1.start();
		t2.start();
	}
}
