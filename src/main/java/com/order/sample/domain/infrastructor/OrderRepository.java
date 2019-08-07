package com.order.sample.domain.infrastructor;

import com.order.sample.domain.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author devagoud
 */
public interface OrderRepository extends ReactiveMongoRepository<Order,String> {
    Mono<Order> findByOrderId(String oredrId);
}
