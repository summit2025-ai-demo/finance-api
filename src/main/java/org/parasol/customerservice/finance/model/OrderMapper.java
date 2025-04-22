package org.parasol.customerservice.finance.model;

import java.util.List;

public class OrderMapper {

    public static OrderDto toDto(Order order) {
        if (order == null) {
            return null;
        }
        List<OrderLineItem> orderLineItems = order.orderLineItems;
        return OrderDto.builder()
                .withId(order.id)
                .withCustomer(order.customer)
                .withOrderDate(order.orderDate)
                .withShippedDate(order.shippedDate)
                .withLineItems(orderLineItems == null ? null : orderLineItems.stream().map(oli -> LineItemDto.builder()
                        .withProduct(oli.product)
                        .withPrice(oli.price)
                        .withQuantity(oli.quantity)
                        .withDiscount(oli.discount)
                        .build()).toList())
                .build();
    }
}
