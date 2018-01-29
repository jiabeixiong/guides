package com.guides.thread.deadlock;

public class LockDemo implements Runnable {

	private String flag;

	private String a="a";

	private String b="b";

	public LockDemo(String flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if ("a".equals(flag)) {
			f1();
		} else {
			f2();
		}
	}

	private void f1() {
		synchronized (a) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			f2();
		}
	}

	private void f2() {
		synchronized (b) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			f1();
		}

	}

}
