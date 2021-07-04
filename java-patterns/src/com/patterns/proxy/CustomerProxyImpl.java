package com.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class CustomerProxyImpl implements Customer{
	
	CustomerImpl custImpl=new CustomerImpl();


	@Override
	public int getId() {
		return custImpl.getId();
	}

	@Override
	public List<Order> getOrders() {
		ArrayList<Order> orders=new ArrayList<Order>();
		Order order1=new Order();
		order1.setId(1);
		order1.setProductName("iPhone");
		order1.setQuantity(100);
		
		Order order2=new Order();
		order2.setId(2);
		order2.setProductName("Max");
		order2.setQuantity(50);
		
		orders.add(order1);
		orders.add(order2);
		return orders;
	}
}
