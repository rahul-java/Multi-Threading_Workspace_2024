package com.thread;

public class ThreadTestUsingRunnable implements Runnable {

	//Thread is nothing but an independent path of the execution in the same program.
	// 3 WAYS TO CREATE THREAD
	//1. Extending Thread class
	//2. Implementing Runnable interface
	//3. Implementing Callable interface

	public static void main(String[] args) {
		
		ThreadTestUsingRunnable tr = new ThreadTestUsingRunnable();
		Thread t = new Thread(tr);
		
		Thread t1=new Thread(new ThreadTestUsingRunnable());
		
		t.start();
		t1.start();
		
	}
	@Override
	public void run() {
		System.out.println("ThreadTestUsingRunnable.run()");
		salaryCalculation();
	}
	
	public void salaryCalculation() {
		System.out.println("ThreadTestUsingRunnable.salaryCalculation()");
	}

}
