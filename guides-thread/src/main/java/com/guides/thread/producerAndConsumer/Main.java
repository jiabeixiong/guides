package com.guides.thread.producerAndConsumer;

public class Main {

	public static void main(String[] args) {
		
		Basket basket = new Basket();
		
		Producer producer = new Producer(basket);
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		
		Consumer consumer = new Consumer(basket);
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		
	}

}
