package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Order;
import com.example.demo.store.OrderRepository;

@RestController
public class OrderResource {
	//
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("orders")
	public List<Order> findAll() {
		//
		return (List<Order>) orderRepository.findAll();
		//return null;
	}
	
	@GetMapping("orders/testdata")
	public void temp() {
		//
		List<Order> orders = new ArrayList<Order>();
		Order order = Order.newInstance();
		order.setName("무농약 대파");
		order.setQuentity(1);
		orders.add(order);
		order = Order.newInstance();
		order.setName("오로라 생연어");
		order.setQuentity(4);
		orders.add(order);
		order = Order.newInstance();
		order.setName("병 샐러드");
		order.setQuentity(2);
		orders.add(order);
		order = Order.newInstance();
		order.setName("미국산 아보카도");
		order.setQuentity(3);
		orders.add(order);
		order = Order.newInstance();
		order.setName("바베큐");
		order.setQuentity(1);
		orders.add(order);
		orderRepository.saveAll(orders);
	}
	
}
