package com.guides.spring.transaction.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guides.spring.transaction.dao.OrderMapper;
import com.guides.spring.transaction.domain.Order;
import com.guides.spring.transaction.service.OrderService;
import com.platform.boot.SpringContextUtil;

@Service
public class OrderServiceImpl implements OrderService{
	
	private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderMapper orderMapper;
	
	private OrderService orderServiceProxy;
	
	@Autowired
	private ApplicationContext appContext;
	
	@PostConstruct
	public void init() {
		this.orderServiceProxy = appContext.getBean(OrderService.class);
	}
	
	@Transactional
	public long createOrder(Order order) {
		long orderId =  orderMapper.insert(order);
		return orderId;
	}

	
	/**
	 * A成功
	 * B失敗
	 */
	@Transactional
	public void funA() {
		System.out.println("----------funA start-----------");
		Order order = new Order();
		order.setDescription("funA");
		orderMapper.insert(order);
		orderServiceProxy.funB();
		System.out.println("----------funB start-----------");
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void funB() {
		System.out.println("----------funB start-----------");
		Order order = new Order();
		order.setDescription("funB");
		orderMapper.insert(order);
		System.out.println("----------funB end-----------");
	}

	@Override
	public void sayHello() {
		
		System.out.println("-------hello--------");
		sayHello2();
		
	}

	@Override
	public void sayHello2() {
		
		System.out.println("-------hello2--------");
		
	}
	
}
