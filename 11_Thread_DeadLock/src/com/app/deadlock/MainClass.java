package com.app.deadlock;

public class MainClass {

	public static void main(String[] args) {
		Object ob1=new Object();
		Object ob2=new Object();
		ThreadTest1 t1=new ThreadTest1(ob1,ob2);
		ThreadTest2 t2=new ThreadTest2(ob1,ob2);
		t1.start();
		t2.start();
		
	}
}
