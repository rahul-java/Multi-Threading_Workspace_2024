package com.thread;

public class NetBankingThread extends Thread{

	@Override
	public void run() {
		System.out.println("NetBankingThread.run()");
		HDFCBank.profileUpdate();
	}
	
}
