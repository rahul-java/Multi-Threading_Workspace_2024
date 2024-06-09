package com.thread;

import java.net.NoRouteToHostException;

public class HDFCBank {

	double acctBal;
	
	public HDFCBank(double acctBal) {
		this.acctBal=acctBal;
	}
	
	synchronized public void withdraw(double withdrawalAmt) throws InterruptedException {
		//Thread.sleep(100000);
		
		if(acctBal<withdrawalAmt)
		{
			wait(); //wait method will release the lock
		}
		System.out.println("Before HDFCBank.withdraw() Balance : "+this.acctBal );
		acctBal=acctBal-withdrawalAmt;
		System.out.println("After HDFCBank.withdraw() Balance : "+this.acctBal );
	}
	
	synchronized public void deposit(double depositedAmt) throws InterruptedException {
		//Thread.sleep(100000); //sleep method doesn't release the lock
		
		System.out.println(" Before HDFCBank.deposit() Balance : "+this.acctBal);
		acctBal=acctBal+depositedAmt;
		System.out.println(" After HDFCBank.deposit() Balance : "+this.acctBal);
		
		notifyAll();// it will revoke the method which is on wait mode on same object
	}
	
	synchronized public void checkBalance() {
		System.out.println("HDFCBank.checkBalance()");
		System.out.println("Balance is "+this.acctBal);
	}

	public void profileUpdate() {
		System.out.println("HDFCBank.profileUpdate()");
	}
}
