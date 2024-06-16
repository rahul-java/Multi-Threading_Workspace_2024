package com.daemon;

public class DaemonThreadTest {

	public static void main(String[] args) {
		DaemonThreadTest d=new DaemonThreadTest();
		d=null;
		System.gc(); // Daemon Thread
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("DaemonThreadTest.finalize()");
	}
}
