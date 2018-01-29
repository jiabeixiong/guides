package com.guides.thread.deadlock;

public class Main {

	public static void main(String[] args) {
		
		new Thread(new LockDemo("a")).start();
		
		new Thread(new LockDemo("b")).start();
		
	}

}
