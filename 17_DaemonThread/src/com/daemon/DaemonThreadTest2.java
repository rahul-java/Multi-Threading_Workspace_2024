package com.daemon;

public class DaemonThreadTest2 extends Thread {

	public static void main(String[] args) {
		DaemonThreadTest2 d=new DaemonThreadTest2();
		d.setDaemon(true); //user defined thread is daemon thread
		System.gc(); // Daemon Thread
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("DaemonThreadTest.finalize()");
	}
}
