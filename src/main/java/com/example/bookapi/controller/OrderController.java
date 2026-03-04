package com.example.bookapi.controller;

import com.example.bookapi.dto.OrderDTO;
import com.example.bookapi.model.Order;
import com.example.bookapi.service.OrderService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;
    public OrderController(OrderService orderService,ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }
        @PostMapping("/user/{userId}")
        public ResponseEntity<OrderDTO> addOrder(@PathVariable Integer userId,@Valid @RequestBody OrderDTO dto) {
            Order order=modelMapper.map(dto,Order.class);
            Order saved=orderService.addOrder(userId,order);
            OrderDTO response=modelMapper.map(saved,OrderDTO.class);
            return ResponseEntity.status(201).body(response);



        }
        @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();

        }
        @GetMapping("/user/{userId}")
        public ResponseEntity <List<OrderDTO>> getOrdersByUser(@PathVariable Integer userId) {
        List<Order> orders= orderService.getOrdersByUser(userId);
        List<OrderDTO> response=new ArrayList<>();
        for(Order order:orders) {
            response.add(modelMapper.map(order,OrderDTO.class));
        }
        return ResponseEntity.ok(response);


        }


    }


