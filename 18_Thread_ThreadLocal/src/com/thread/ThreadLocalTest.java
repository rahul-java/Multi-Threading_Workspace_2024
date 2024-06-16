package com.thread;

public class ThreadLocalTest {

	static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				threadLocal.set(10);
				System.out.println(threadLocal.get());
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				threadLocal.set(20);
				System.out.println(threadLocal.get());
			}
		});
		
		t2.start();
		t1.start();
	}
}
