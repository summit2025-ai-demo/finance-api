package org.parasol.customerservice.finance.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class OrderFinancialRecordMapper {

    public static OrderFinancialRecord toDto(Order order) {
        if (order == null) {
            return null;
        }
        return OrderFinancialRecord.builder()
                .withId(order.id)
                .withCustomer(order.customer)
                .withOrderDate(order.orderDate)
                .withShippedDate(order.shippedDate)
                .withStatus(order.shippedDate != null ? "completed" : "pending")
                .withValue(getTotalOrderValue(order.orderLineItems))
                .build();
    }

    private static BigDecimal getTotalOrderValue(List<OrderLineItem> lineItems) {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderLineItem lineItem : lineItems) {
            BigDecimal i1 = lineItem.price.multiply(BigDecimal.valueOf(lineItem.quantity));
            BigDecimal i2 = i1.multiply(lineItem.discount);
            BigDecimal i3 = i1.subtract(i2).setScale(2, RoundingMode.HALF_UP);
            total = total.add(i3);
        }
        return total;
    }
}
