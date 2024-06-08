package com.thread;

public class ThreadTest extends Thread {

	//Thread is nothing but an independent path of the execution in the same program.
	// 3 WAYS TO CREATE THREAD
	//1. Extending Thread class
	//2. Implementing Runnable interface
	//3. Implementing Callable interface

	public ThreadTest() {
		super();
	}
	
	public ThreadTest(String str)
	{
		super(str);
	}
	public static void main(String[] args) {

		//ThreadTest t1 = new ThreadTest();
		//ThreadTest t2 = new ThreadTest();
		
		ThreadTest t1 = new ThreadTest("First-Thread");
		ThreadTest t2 = new ThreadTest("Second-Thread");
		
		t1.setName("Ist Thread");
		t2.setName("IInd Thread");
		
		t1.start(); //Thread-0 => it creates the independent path of execution :: Runnable Pool
		//t1.run(); // it will not create the independent path of execution, it execute like a normal instance method
		t2.start(); //Thread-1
		//t1.start();  //IllegalThreadStateException
		//Disadvantages : we can not re-use the thread
	}

	//Running State
	@Override
	public void run() {
		System.out.println("ThreadTest.run() ::: "+Thread.currentThread().getName());
		salaryCalculation();
	}//Dead State
	
	public void salaryCalculation() {
		System.out.println("ThreadTest.salaryCalculation()");
	}

}
