package com.app.deadlock;

public class ThreadTest1 extends Thread {

	Object obj1=null;
	Object obj2=null;
	
	public ThreadTest1(Object obj1,Object obj2) {
		this.obj1=obj1;
		this.obj2=obj2;	
	}
	
	@Override
	public void run() {
		System.out.println("ThreadTest1.run()");
		
		System.out.println("Thread-1 is about to acquire the lock on object-1");
		synchronized (obj1) {
			System.out.println("Thread-1 has acquired the lock on object-1");
		}
		System.out.println("Thread-1 has released the lock on object-1");
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=========================================================================");
		
		System.out.println("Thread-1 is about to acquire the lock on object-2");
		synchronized (obj2) {
			System.out.println("Thread-1 has acquired the lock on object-2");
		}
		System.out.println("Thread-1 has released the lock on object-2");
	}
}
