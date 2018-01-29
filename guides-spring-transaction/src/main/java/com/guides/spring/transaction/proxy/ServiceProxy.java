package com.guides.spring.transaction.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.guides.spring.transaction.service.OrderService;

public class ServiceProxy implements InvocationHandler{
	
	private OrderService orderService;
	
	public ServiceProxy(OrderService orderService){
		this.orderService = orderService;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("------proxy-------");
		Object obj  = method.invoke(orderService);
		
		return obj;
	}

}
