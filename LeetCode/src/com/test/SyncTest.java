package com.test;

public class SyncTest {
	public synchronized static void func1(){
		System.out.println("func1");
		
	}
	public synchronized void func2(){
		func3();
		System.out.println("func2");
		
	}
	public synchronized void func3(){
		System.out.println("func3");
	}

}
