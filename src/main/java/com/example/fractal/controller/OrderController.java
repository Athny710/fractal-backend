package com.example.fractal.controller;

import com.example.fractal.persistence.dto.OrderDto;
import com.example.fractal.persistence.entity.OrderEntity;
import com.example.fractal.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    // Obtener todos los pedidos
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders(){
        List<OrderEntity> orderList = orderService.getAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    // Obtener un pedido por su ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable("id") Long id){
        OrderEntity order = this.orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Guardar un nuevo pedido
    @PostMapping
    public ResponseEntity<OrderEntity> saveOrder(@RequestBody OrderDto orderDto){
        OrderEntity order = this.orderService.saveOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Editar un pedido
    @PutMapping
    public ResponseEntity<Void> updateOrder(@RequestBody OrderEntity orderToUpdate){
        this.orderService.updateOrder(orderToUpdate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
