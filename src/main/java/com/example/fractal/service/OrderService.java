package com.example.fractal.service;

import com.example.fractal.exception.BaseException;
import com.example.fractal.mapper.OrderMapper;
import com.example.fractal.persistence.dto.OrderDto;
import com.example.fractal.persistence.entity.OrderEntity;
import com.example.fractal.persistence.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    // Obtener todos los pedidos existentes
    public List<OrderEntity> getAllOrders(){
        return this.orderRepository.findAll();
    }

    // Obtener un pedido por su ID
    public OrderEntity getOrderById(Long id){
        return this.orderRepository.findById(id).orElseThrow( () ->
                new BaseException("No existe el pedido con el ID brindado", HttpStatus.NOT_FOUND)
        );
    }

    // Guardar un nuevo pedido
    public OrderEntity saveOrder(OrderDto orderDto){
        OrderEntity order = orderMapper.map(orderDto);
        return this.orderRepository.save(order);
    }

    // Actualizar la información de un pedido
    public void updateOrder(OrderEntity order){
        Optional<OrderEntity> optOrder = this.orderRepository.findById(order.getId());
        if(!optOrder.isPresent())
            throw new BaseException("No existe el pedido con el ID brindado", HttpStatus.NOT_FOUND);
        this.orderRepository.save(order);
    }
}
