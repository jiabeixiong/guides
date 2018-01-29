package com.guides.thread.producerAndConsumer;

import java.util.Random;

public class Consumer implements Runnable {

	private Basket basket;

	public Consumer(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		while (true) {
			if (basket.size() == 0) {
				synchronized (this) {
					System.err.println(Thread.currentThread().getId()+  "  篮子吃空了。。。" );
					try {
						synchronized (basket) {
							basket.wait();
							continue;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			Bread bread = basket.remove(0);
			System.err.println(Thread.currentThread().getId()+  "  消费了一个面包：" + bread.getId());
			synchronized (basket) {
				basket.notifyAll();
			}
			int sleepTime = new Random().nextInt(2000);

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
