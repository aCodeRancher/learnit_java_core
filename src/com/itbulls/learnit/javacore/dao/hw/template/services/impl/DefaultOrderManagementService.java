
package com.itbulls.learnit.javacore.dao.hw.template.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.itbulls.learnit.javacore.dao.hw.template.dao.MySqlJdbcOrderDao;
import com.itbulls.learnit.javacore.dao.hw.template.dao.MySqlJdbcUserDao;
import com.itbulls.learnit.javacore.dao.hw.template.dto.OrderDto;
import com.itbulls.learnit.javacore.dao.hw.template.dto.converter.OrderConverter;
import com.itbulls.learnit.javacore.dao.hw.template.dto.converter.UserConverter;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.Order;
import com.itbulls.learnit.javacore.dao.hw.template.services.OrderManagementService;
import com.itbulls.learnit.javacore.dao.hw.template.storage.OrderStoringService;
import com.itbulls.learnit.javacore.dao.hw.template.storage.impl.DefaultOrderStoringService;


public class DefaultOrderManagementService implements OrderManagementService {

	private static DefaultOrderManagementService instance;
	private List<Order> orders;
	private OrderStoringService orderStoringService;
	private static OrderConverter orderConverter;
	private static MySqlJdbcOrderDao mySqlJdbcOrderDao;

	{
		orderStoringService = DefaultOrderStoringService.getInstance();
		orders = orderStoringService.loadOrders();
		orderConverter = OrderConverter.getInstance();
		mySqlJdbcOrderDao = MySqlJdbcOrderDao.getInstance();
	}
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		 OrderDto orderDto = orderConverter.orderToOrderDto(order);
		 mySqlJdbcOrderDao.saveOrder(orderDto);
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		List<OrderDto> orderDtoList = mySqlJdbcOrderDao.getOrdersByUserId(userId);
		return orderDtoList.stream().map(orderDto -> orderConverter.orderDtoToOrder(orderDto))
				.collect(Collectors.toList());
	}

	@Override
	public List<Order> getOrders() {
		List<OrderDto> orderDtoList = mySqlJdbcOrderDao.getOrders();
		return orderDtoList.stream().map(orderDto -> orderConverter.orderDtoToOrder(orderDto))
				.collect(Collectors.toList());
	}
	
	void clearServiceState() {
		orders.clear();
	}

}
