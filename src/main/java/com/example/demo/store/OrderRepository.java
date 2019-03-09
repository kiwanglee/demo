package com.example.demo.store;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, String> {

}
