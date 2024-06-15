package com.thread.synchronize;

import java.awt.DisplayMode;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	// private Lock lock=new ReentrantLock(); // unfairLock
	// private Lock lock=new ReentrantLock(false); // unfairLock
	private Lock lock = new ReentrantLock(true); // fairLock

	void display1(LockTest lt) {

		// create the lock
		lock.lock();
		display2(lt);
		
		System.out.println("LockTest.display1()");
		System.out.println("Hi-1");
		System.out.println("Hi-2");
		System.out.println("Hi-3");
		System.out.println("Hi-4");

		// lock.unlock();
	}

	void display2(LockTest lt) {

		System.out.println("LockTest.display2()");
		System.out.println("Hi Hi => 1");
		System.out.println("Hi Hi => 2");

		System.out.println("Hi Hi => 3");
		System.out.println("Hi Hi => 4");
		
		lock.unlock();

	}

	public static void main(String[] args) {
		LockTest lt = new LockTest();
		Thread t1 = new Thread(() -> lt.display1(lt));
		Thread t2 = new Thread(() -> lt.display1(lt));
		Thread t3 = new Thread(() -> lt.display1(lt));
		Thread t4 = new Thread(() -> lt.display1(lt));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
