package com.thread;

public class PhonePeThread extends Thread{

	private HDFCBank bankAccount;
	
	public PhonePeThread(HDFCBank bankAccount) {
		this.bankAccount=bankAccount;
	}
	
	@Override
	public void run() {
		System.out.println("PhonePeThread.run()");
		bankAccount.checkBalance();
	}
	
}
