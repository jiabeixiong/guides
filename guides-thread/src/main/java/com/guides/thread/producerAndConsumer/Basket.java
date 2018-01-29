package com.guides.thread.producerAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private int index;
	
	private List<Bread> breads = new ArrayList<Bread>();
	
	public synchronized int add() {
		breads.add(new Bread(index ));
		return index ++;
	}
	
	
	public synchronized Bread remove(int index) {
		return breads.remove(index);
	}
	
	
	public synchronized int size() {
		return breads.size();
	}
	
	
	
}
