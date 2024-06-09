package com.thread;

public class PhonePeThread extends Thread{

	@Override
	public void run() {
		System.out.println("PhonePeThread.run()");
		HDFCBank.checkBalance();
	}
	
}
