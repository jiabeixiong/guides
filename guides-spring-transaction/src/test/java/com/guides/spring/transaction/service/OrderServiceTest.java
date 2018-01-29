package com.guides.spring.transaction.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import com.guides.spring.transaction.SupperTest;
import com.guides.spring.transaction.domain.Order;


@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@ComponentScan("com.**")
public class OrderServiceTest extends SupperTest{

	private Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testCreateOrder() {
		
		try {
			orderService.funA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
