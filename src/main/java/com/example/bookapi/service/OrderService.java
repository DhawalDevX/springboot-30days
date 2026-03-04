package com.example.bookapi.service;

import com.example.bookapi.exception.UserNotFoundException;
import com.example.bookapi.model.Order;
import com.example.bookapi.model.User;
import com.example.bookapi.repository.OrderRepository;
import com.example.bookapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    // CREATE
    public Order addOrder(Integer userId, Order order) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id " + userId));
        order.setUser(user);
        return orderRepository.save(order);
    }

    // GET ALL ORDERS OF A USER
    public List<Order> getOrdersByUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id " + userId));
        return user.getOrders();
    }

    // DELETE
    public void deleteOrder(Integer orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException(
                    "Order not found with id " + orderId);
        }
        orderRepository.deleteById(orderId);
    }
}