package com.join;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleThreadsJoinTest {
	
	static CountDownLatch cdl=new CountDownLatch(10);
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService ex = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<10;i++)
		{
			
			ex.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("MultipleThreadsJoinTest.main(...).new Runnable() {...}.run() ::: "+Thread.currentThread().getName());
					//salary calculation
					cdl.countDown(); //replacement of join
				}
			});
		}
		cdl.await(); //replacement of join
		//System.out.println(cdl.getCount());
		
		//generate file
		System.out.println("MultipleThreadsJoinTest.main()");
		System.out.println("MultipleThreadsJoinTest.main()");
		System.out.println("MultipleThreadsJoinTest.main()");
		System.out.println("MultipleThreadsJoinTest.main()");
		System.out.println("MultipleThreadsJoinTest.main()");
		System.out.println("MultipleThreadsJoinTest.main()");
		System.out.println("MultipleThreadsJoinTest.main()");
	}
}
