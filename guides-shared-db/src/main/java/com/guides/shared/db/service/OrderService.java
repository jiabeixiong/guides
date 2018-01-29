package com.guides.shared.db.service;

import java.util.List;

import com.guides.shared.db.domain.Order;

public interface OrderService {

	
	public List<Order> findAll();
	
	
	public int createOrder(Order order);
	
	
}
