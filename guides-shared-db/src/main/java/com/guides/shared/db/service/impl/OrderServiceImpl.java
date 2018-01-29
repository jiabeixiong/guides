package com.guides.shared.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guides.shared.db.annotations.DataSourceOptionType;
import com.guides.shared.db.annotations.TargetDataSource;
import com.guides.shared.db.dao.OrderMapper;
import com.guides.shared.db.domain.Order;
import com.guides.shared.db.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	@TargetDataSource(DataSourceOptionType.READ)
	public List<Order> findAll() {
		return orderMapper.findAll();
	}

	@Override
	@Transactional
	@TargetDataSource(DataSourceOptionType.WRITE)
	public int createOrder(Order order) {
		return orderMapper.insert(order);
	}

}
