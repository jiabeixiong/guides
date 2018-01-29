package com.guides.spring.transaction.proxy;

import java.lang.reflect.Proxy;

import com.guides.spring.transaction.service.OrderService;
import com.guides.spring.transaction.service.impl.OrderServiceImpl;

public class ProxyTest {

	public static void main(String[] args) {
		
		OrderService os = new OrderServiceImpl();
		
		OrderService proxy = (OrderService) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[] {OrderService.class}, new ServiceProxy(os));
		
		proxy.sayHello();
	}

}
