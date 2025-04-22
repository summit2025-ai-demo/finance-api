package org.parasol.customerservice.finance.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.parasol.customerservice.finance.model.Order;
import org.parasol.customerservice.finance.model.OrderFinancialRecord;
import org.parasol.customerservice.finance.model.OrderFinancialRecordMapper;

import java.util.List;

@ApplicationScoped
public class OrderService {

    @Transactional
    public List<OrderFinancialRecord> getOrdersByCustomerId(String customerId) {
        List<Order> orders = Order.list("customer", customerId);
        return orders.stream().map(OrderFinancialRecordMapper::toDto).toList();
    }

}
