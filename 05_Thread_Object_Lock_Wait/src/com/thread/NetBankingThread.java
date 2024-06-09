package com.thread;

public class NetBankingThread extends Thread{

	private HDFCBank bankAccount;
	
	public NetBankingThread(HDFCBank bankAccount) {
		this.bankAccount=bankAccount;
	}
	
	@Override
	public void run() {
		System.out.println("NetBankingThread.run()");
		bankAccount.profileUpdate();
	}
	
}
