package com.guides.java8;

public class Main2 {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(" inner class ");
			}
		}).start();
		
		new Thread(()->System.out.println(" lambda class ")).start();
		
	}
	
	


}
