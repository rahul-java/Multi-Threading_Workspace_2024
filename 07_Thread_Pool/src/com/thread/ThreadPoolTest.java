package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	
	//Thread-Pool :: java 1.5v Executor Framework
	//1.Single Thread-Pool
	//2.Cached Thread-Pool
	//3.Scheduled Thread-Pool
	//4.Fixed Thread-Pool
	
	public static void main(String[] args) {
		
		ExecutorService ex = Executors.newFixedThreadPool(3);
		ex.execute(null);
		//ex.submit(null);
	}

}
