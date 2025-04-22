package org.parasol.customerservice.finance.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderFinancialRecord {

    private int id;

    private String customer;

    private LocalDate orderDate;

    private LocalDate shippedDate;

    private String status;

    private BigDecimal value;

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

    public String getStatus() {
        return status;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        
        private final OrderFinancialRecord orderFinancialRecord;
        
        public Builder() {
            orderFinancialRecord = new OrderFinancialRecord();
        }

        public Builder withId(int id) {
            orderFinancialRecord.id = id;
            return this;
        }

        public Builder withCustomer(String customer) {
            orderFinancialRecord.customer = customer;
            return this;
        }

        public Builder withOrderDate(LocalDate orderDate) {
            orderFinancialRecord.orderDate = orderDate;
            return this;
        }

        public Builder withShippedDate(LocalDate shippedDate) {
            orderFinancialRecord.shippedDate = shippedDate;
            return this;
        }

        public Builder withStatus(String status) {
            orderFinancialRecord.status = status;
            return this;
        }

        public Builder withValue(BigDecimal value) {
            orderFinancialRecord.value = value;
            return this;
        }

        public OrderFinancialRecord build() {
            return orderFinancialRecord;
        }
    }
}
