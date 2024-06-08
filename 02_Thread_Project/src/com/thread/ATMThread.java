package com.thread;

public class ATMThread extends Thread{
	
	private HDFCBank bankAccount;
	
	public ATMThread(HDFCBank bankAccount) {
		this.bankAccount=bankAccount;
	}

	@Override
	public void run() {
		System.out.println("ATMThread.run()");
		bankAccount.withdraw(4000.0);
	}
	
}
