package com.thread;

public class ThreadLocalTest2 extends Thread{

	static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	@Override
	public void run() {
		
		/*if(Thread.currentThread().isInterrupted())
		{
			Thread.currentThread().stop();
		}*/
		
		threadLocal.set(100);
		display();
		threadLocal.set(threadLocal.get()+10000);
		threadLocal.set(threadLocal.get()+10000);
		System.out.println(threadLocal.get());
	}

	private void display() {
		// TODO Auto-generated method stub
		threadLocal.set(200);
		System.out.println(threadLocal.get());
	}
	
	public static void main(String[] args) {
		
		ThreadLocalTest2 test2 = new ThreadLocalTest2();
		test2.start();
		
		ThreadLocalTest2 test22 = new ThreadLocalTest2();
		test22.start();
	}
}
