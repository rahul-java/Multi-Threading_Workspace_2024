package com.thread;

public class ATMThread extends Thread{
	
	private HDFCBank bankAccount;
	
	public ATMThread(HDFCBank bankAccount) {
		this.bankAccount=bankAccount;
	}

	@Override
	public void run() {
		System.out.println("ATMThread.run()");
		try {
			bankAccount.withdraw(10000.0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
