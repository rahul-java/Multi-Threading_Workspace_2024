package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class NonSyncTest {

	//static volatile int count=0; //it also behave differently each time
	
	static AtomicInteger count=new AtomicInteger(0); // always return correct value

	//static int count=0; //it behave differently each time
	
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 1000; i++) {
					//count++;
					count.incrementAndGet(); // for atomic var
				}
			}
		});
		

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 1000; i++) {
					//count++;
					count.incrementAndGet(); // for atomic var
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count ::: "+count);
	}
}
