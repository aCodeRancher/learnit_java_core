package com.itbulls.learnit.javacore.dao.hw.template.dao;

import com.itbulls.learnit.javacore.dao.hw.template.dto.OrderDto;
import com.itbulls.learnit.javacore.dao.hw.template.dto.ProductDto;

import java.util.List;

public interface OrderDao {

    List<OrderDto> getOrdersByUserId(int userid);
    void saveOrder(OrderDto orderDto);
    List<OrderDto> getOrders();

}
