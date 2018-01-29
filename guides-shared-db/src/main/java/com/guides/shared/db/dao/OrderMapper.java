package com.guides.shared.db.dao;

import java.util.List;

import com.guides.shared.db.domain.Order;

public interface OrderMapper {
	

    int insert(Order record);
    
    public List<Order> findAll();
}