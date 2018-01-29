package com.guides.thread.producerAndConsumer;

public class Producer implements Runnable {

	private Basket basket;

	public Producer(Basket basket) {
		this.basket = basket;
	}

	public void run() {
		while (true) {
			if (basket.size() > 10) {
				System.out.println(Thread.currentThread().getId()+  " 篮子堆满了。。。。 ");
				try {
					synchronized (basket) {
						basket.wait();
						continue;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int index = basket.add();
			System.out.println(Thread.currentThread().getId()+  "   生产了一个面包：" + index);
			synchronized (basket) {
				basket.notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
