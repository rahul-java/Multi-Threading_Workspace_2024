package com.thread;

public class ATMThread extends Thread{

	@Override
	public void run() {
		System.out.println("ATMThread.run()");
		HDFCBank.withdraw(4000.0);
	}
	
}
