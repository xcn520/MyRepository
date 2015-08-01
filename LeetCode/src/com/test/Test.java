package com.test;


public class Test{

	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadSync(new SyncTest()));
		
		Thread t2 = new Thread(new ThreadSync2(new SyncTest()));
//		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.start();
	}
	
	private static class ThreadSync implements Runnable{

		@Override
		public void run() {
			source.func2();
		}
		
		private SyncTest source;
		
		ThreadSync(SyncTest source){
			this.source = source;
		}
	}
	
	private static class ThreadSync2 implements Runnable{

		@Override
		public void run() {
			source.func2();
		}
		
		private SyncTest source;
		
		ThreadSync2(SyncTest source){
			this.source = source;
		}
	}

}
