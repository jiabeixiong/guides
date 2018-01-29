package com.guides.thread.volatiles;

public class VolatileTest {

	volatile int index = 0;
	
	public  void add() {
		
		index++;
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		VolatileTest v = new VolatileTest();
		new Thread(()->{
			for(int i = 0;i<4000;i++) {
				v.add();
			}
		})  .start();
		
		for(int i = 0;i<4000;i++) {
			
			v.add();
			
		}
		
		while(Thread.activeCount()>1) {
			Thread.yield();
		}
		
		System.out.println(v.getIndex());
		
		
	}
	
}
