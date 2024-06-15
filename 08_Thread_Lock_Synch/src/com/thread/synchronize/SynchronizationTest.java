package com.thread.synchronize;

public class SynchronizationTest {

	synchronized void display1(SynchronizationTest st) {

		System.out.println("SynchronizationTest.display1()");
		System.out.println("Hi-1");
		System.out.println("Hi-2");
		System.out.println("Hi-3");
		System.out.println("Hi-4");
	}

	 void display2(SynchronizationTest st) {
		
		System.out.println("SynchronizationTest.display2()");
		System.out.println("Hi Hi => 1");
		System.out.println("Hi Hi => 2");
		
		synchronized (st) {
			System.out.println("Hi Hi => 3");
			System.out.println("Hi Hi => 4");
		}

	}
	
	public static void main(String[] args) {
		
		//class implements Runnable (I)
		SynchronizationTest sTest = new SynchronizationTest();
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				//sTest.display1(sTest);
				sTest.display2(sTest);
			}
		});
		t.start();
		
		//========================================================================
		
		/*Runnable r=()->{
			sTest.display1(sTest);
		};*/
		Runnable r=()->sTest.display1(sTest);
		Thread t1=new Thread(r);
		t1.start();
		
		//===========================================================================
		
		Thread t2=new Thread(()->{
			sTest.display2(sTest);
		});
		t2.start();
		
		//=============================================================================
		
		new Thread(()->{
			sTest.display2(sTest);
		}).start();
		
	}

}
