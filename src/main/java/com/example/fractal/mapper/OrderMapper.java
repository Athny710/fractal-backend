package com.example.fractal.mapper;

import com.example.fractal.persistence.dto.OrderDto;
import com.example.fractal.persistence.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Clase que permite mapear un objeto de tipo OrderDto a un objeto de clase OrderEntity

@Component
public class OrderMapper implements IMapper<OrderDto, OrderEntity> {

    @Override
    public OrderEntity map(OrderDto in) {
        OrderEntity order = new OrderEntity();
        order.setId(in.getId());
        order.setStatus(in.getStatus());
        order.setUser(in.getUser());
        order.setTotal(in.getTotal());
        order.setDate(LocalDate.now());

        return order;
    }
}
