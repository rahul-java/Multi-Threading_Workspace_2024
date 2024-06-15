package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HDFCBank {

	double acctBal = 0;
	ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();

	public HDFCBank(double acctBal) {
		this.acctBal = acctBal;
	}

	synchronized public void withdraw(double withdrawalAmt) {

		// Lock wl = rrwl.writeLock();
		// wl.lock();
		rrwl.writeLock().lock();

		System.out.println("Before HDFCBank.withdraw() Balance : " + this.acctBal);
		acctBal = acctBal - withdrawalAmt;
		System.out.println("After HDFCBank.withdraw() Balance : " + this.acctBal);

		rrwl.writeLock().unlock();

	}

	public void deposit(double depositedAmt) {

		// Lock wl = rrwl.writeLock();
		// wl.lock();
		rrwl.writeLock().lock();

		System.out.println(" Before HDFCBank.deposit() Balance : " + this.acctBal);
		acctBal = acctBal + depositedAmt;
		System.out.println(" After HDFCBank.deposit() Balance : " + this.acctBal);

		rrwl.writeLock().unlock();
	}

	public void checkBalanceByUPI() {

		try {
			rrwl.readLock().lock();

			System.out.println("HDFCBank.checkBalanceByUPI()");
			System.out.println("Balance is " + this.acctBal);

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			rrwl.readLock().unlock(); //best way to write in finally block
		}
	 //rrwl.readLock().unlock();	
	}

	public void checkBalanceByNetBanking() {

		rrwl.readLock().lock();

		System.out.println("HDFCBank.checkBalanceByNetBanking()");
		System.out.println("Balance is " + this.acctBal);

		rrwl.readLock().unlock();
	}

	public void checkBalanceByMobileApp() {

		rrwl.readLock().lock();

		System.out.println("HDFCBank.checkBalanceByMobileApp()");
		System.out.println("Balance is " + this.acctBal);

		rrwl.readLock().unlock();
	}

	public static void main(String[] args) {

		HDFCBank rahul = new HDFCBank(7000);

		Thread t1 = new Thread(() -> rahul.deposit(5000.0)); //write operation
		t1.start();
		Thread t2 = new Thread(() -> rahul.withdraw(5000.0)); //write operation
		t2.start();
		Thread t3 = new Thread(() -> rahul.checkBalanceByUPI()); //read operation
		t3.start();
		Thread t4 = new Thread(() -> rahul.checkBalanceByMobileApp()); //read operation
		t4.start();
		Thread t5 = new Thread(() -> rahul.checkBalanceByNetBanking()); //read operation
		t5.start();
		
	}
}
