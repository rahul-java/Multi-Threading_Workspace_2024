package com.thread;

public class GPayThread extends Thread{

	@Override
	public void run() {
		System.out.println("GPayThread.run()");
		HDFCBank.deposit(5000.0);
	}
	
}
