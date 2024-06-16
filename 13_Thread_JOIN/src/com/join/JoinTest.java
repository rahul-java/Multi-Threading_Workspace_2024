package com.join;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("JoinTest.main(...).new Runnable() {...}.run()");
				
			}
		});
		
		t.start();
		t.join(); //main thread will goto the wait mode
		

		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("JoinTest.main(...).new Runnable() {...}.run() => File Preparation");
				
			}
		});
		
		t1.start();
		t1.join();
		
		System.out.println("Welcome to Joins");
		System.out.println("My name is Rahul");
	}
}
