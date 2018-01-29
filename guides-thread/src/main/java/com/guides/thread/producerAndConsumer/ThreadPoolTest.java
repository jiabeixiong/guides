package com.guides.thread.producerAndConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		Basket basket = new Basket();
		
		Producer producer = new Producer(basket);
		Consumer consumer = new Consumer(basket);
		ExecutorService  pool = Executors.newFixedThreadPool(6);
		pool.execute(producer);
		pool.execute(producer);
		pool.execute(producer);
		
		pool.execute(consumer);
		pool.execute(consumer);
		pool.execute(consumer);
	}

}
