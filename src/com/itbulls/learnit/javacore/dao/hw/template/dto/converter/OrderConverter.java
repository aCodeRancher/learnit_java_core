package com.itbulls.learnit.javacore.dao.hw.template.dto.converter;

import com.itbulls.learnit.javacore.dao.hw.template.dto.OrderDto;
import com.itbulls.learnit.javacore.dao.hw.template.dto.ProductDto;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.Order;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.Product;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.impl.DefaultOrder;
import java.util.List;
import java.util.stream.Collectors;

public class OrderConverter {
    private static OrderConverter instance;

    private OrderConverter() {};


    public static OrderConverter getInstance() {
        if (instance == null) {
            instance = new OrderConverter();
        }
        return instance;
    }

    public OrderDto orderToOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setUser_id(order.getCustomerId());
        orderDto.setProduct_id(order.getProduct_id());
        orderDto.setCreditcard(order.getCreditCardNumber());
         return orderDto;
    }

    public Order orderDtoToOrder(OrderDto orderDto){
         Order order = new DefaultOrder();
         order.setCustomerId(orderDto.getUser_id());
         order.setProduct_id(orderDto.getProduct_id());
         order.setCreditCardNumber(orderDto.getCreditcard());
        return order;
    }
}
