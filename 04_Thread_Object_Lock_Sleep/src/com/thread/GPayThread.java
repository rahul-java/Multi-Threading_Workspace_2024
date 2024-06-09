package com.thread;

public class GPayThread extends Thread{

	private HDFCBank bankAccount;
	
	public GPayThread(HDFCBank bankAccount) {
		this.bankAccount=bankAccount;
	}
	
	@Override
	public void run() {
		System.out.println("GPayThread.run()");
		try {
			bankAccount.deposit(5000.0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
