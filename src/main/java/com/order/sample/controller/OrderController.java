package com.order.sample.controller;

import com.order.sample.ResponseMesage;
import com.order.sample.domain.Order;
import com.order.sample.domain.infrastructor.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author devagoud
 */
@Controller
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @PostMapping("/order")
    public ResponseEntity<ResponseMesage> createOrder(@RequestBody Order order) {
        Mono<Order> orderMono = orderRepository.save(order);
        return ResponseEntity.ok(new ResponseMesage("created successfully"));
    }
    @GetMapping("/order")
    public ResponseEntity<Flux<Order>> getOrders() {
        this.messagingTemplate.convertAndSend("/topic/reply", orderRepository.findAll().collectList().block());

        return ResponseEntity.ok( orderRepository.findAll());
    }
    @GetMapping("/item/{orderId}")
    public ResponseEntity<Order> getItem(@PathVariable String orderId) {
        return ResponseEntity.ok( orderRepository.findByOrderId(orderId).block());
    }
}
