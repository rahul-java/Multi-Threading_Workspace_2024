package com.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	private static final int NUM_THREADS=5;
	private static final int NUM_PERMITS=2;
	
	//Semaphore is to restrict the thread at a time only NUM_PERMITS(2)[fixed no. of threads] threads are allowed to execute the logic
	private static Semaphore semaphore=new Semaphore(NUM_PERMITS);
	
	public static void main(String[] args) {
		for(int i=1;i<=NUM_THREADS;i++)
		{
			Thread t=new Thread(new Worker(i));
			t.start();
		}
	}
	
	private static class Worker implements Runnable{
		
		private int id;
		
		public Worker(int id) {
			this.id=id;
		}
		
		@Override
		public void run() {
			
			try {
				synchronized (this) {
					System.out.println("Thread "+id+" is waiting for permission");
					semaphore.acquire();
					System.out.println("Thread "+id+" has acquired a permit");
					Thread.sleep(1000);
					semaphore.release();
					System.out.println("Thread "+id+" has released a permit");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
