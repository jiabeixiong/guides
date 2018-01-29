package com.guides.shared.db.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.guides.shared.db.domain.Order;
import com.guides.shared.db.service.OrderService;


@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@ComponentScan("com.**")
public class OrderServiceTest {

	private Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testCreateOrder() {
		
		try {
			Order o = new Order();
			o.setDescription("write");
			orderService.createOrder(o);
			List<Order> list = orderService.findAll();
			list.forEach(order ->System.out.println(order));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
