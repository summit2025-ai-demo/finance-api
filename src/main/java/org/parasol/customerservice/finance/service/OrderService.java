package org.parasol.customerservice.finance.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.parasol.customerservice.finance.model.Order;
import org.parasol.customerservice.finance.model.OrderDto;
import org.parasol.customerservice.finance.model.OrderMapper;

import java.util.List;

@ApplicationScoped
public class OrderService {

    @Transactional
    public List<OrderDto> getOrdersByCustomerId(String customerId) {
        List<Order> orders = Order.list("customer", customerId);
        return orders.stream().map(OrderMapper::toDto).toList();
    }

}
