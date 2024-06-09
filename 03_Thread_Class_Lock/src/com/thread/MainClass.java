package com.thread;

public class MainClass {

	public static void main(String[] args) {
		
		ATMThread atmThread = new ATMThread();
		atmThread.setName("ATM-Thread");
		
		GPayThread gPayThread = new GPayThread();
		gPayThread.setName("GPay-Thread");
		
		PhonePeThread phonePeThread = new PhonePeThread();
		phonePeThread.setName("PhonePe-Thread");
		
		NetBankingThread netBankingThread = new NetBankingThread();
		phonePeThread.setName("PhonePe-Thread");
		
		atmThread.start();
		gPayThread.start();
		phonePeThread.start();
		netBankingThread.start();
	}
}
