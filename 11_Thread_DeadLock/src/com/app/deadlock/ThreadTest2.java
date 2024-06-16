package com.app.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 extends Thread {

	Object obj1=null;
	Object obj2=null;
	
	Lock rl=new ReentrantLock();
	
	public ThreadTest2(Object obj1,Object obj2) {
		this.obj1=obj1;
		this.obj2=obj2;	
	}
	
	@Override
	public void run() {
		System.out.println("ThreadTest2.run()");
		
		if(rl.tryLock())
		{
			//true
			//stmt
		}
		else {
			//false
			//stmt
		}
		
		System.out.println("Thread-2 is about to acquire the lock on object-2");
		synchronized (obj2) {
			System.out.println("Thread-2 has acquired the lock on object-2");
		}
		System.out.println("Thread-2 has released the lock on object-2");
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=========================================================================");
		
		System.out.println("Thread-2 is about to acquire the lock on object-1");
		synchronized (obj1) {
			System.out.println("Thread-2 has acquired the lock on object-1");
		}
		System.out.println("Thread-2 has released the lock on object-1");
	}
}
