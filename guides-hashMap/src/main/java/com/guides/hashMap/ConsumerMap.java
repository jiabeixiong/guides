package com.guides.hashMap;

public interface ConsumerMap<K,V> {

	
	public V get(K k);
	
	public V set(K k,V v);
	
	public int size();
	
	
}
