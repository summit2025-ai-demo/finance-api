package org.parasol.customerservice.finance.model;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {

    private int id;

    private String customer;

    private LocalDate orderDate;

    private LocalDate shippedDate;

    private List<LineItemDto> lineItems;

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public List<LineItemDto> getLineItems() {
        return lineItems;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        
        private final OrderDto orderDto;
        
        public Builder() {
            orderDto = new OrderDto();
        }

        public Builder withId(int id) {
            orderDto.id = id;
            return this;
        }

        public Builder withCustomer(String customer) {
            orderDto.customer = customer;
            return this;
        }

        public Builder withOrderDate(LocalDate orderDate) {
            orderDto.orderDate = orderDate;
            return this;
        }

        public Builder withShippedDate(LocalDate shippedDate) {
            orderDto.shippedDate = shippedDate;
            return this;
        }

        public Builder withLineItems(List<LineItemDto> lineItems) {
            orderDto.lineItems = lineItems;
            return this;
        }

        public OrderDto build() {
            return orderDto;
        }
    }
}
