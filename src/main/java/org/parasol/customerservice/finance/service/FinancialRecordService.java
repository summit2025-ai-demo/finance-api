package org.parasol.customerservice.finance.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.parasol.customerservice.finance.model.Order;
import org.parasol.customerservice.finance.model.FinancialRecord;
import org.parasol.customerservice.finance.model.FinancialRecordMapper;

import java.util.List;

@ApplicationScoped
public class FinancialRecordService {

    @Transactional
    public List<FinancialRecord> getRecordsByCustomerId(String customerId) {
        List<Order> orders = Order.list("customer", customerId);
        return orders.stream().map(FinancialRecordMapper::toDto).toList();
    }

}
