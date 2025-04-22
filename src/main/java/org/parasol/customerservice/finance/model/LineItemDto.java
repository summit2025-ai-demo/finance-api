package org.parasol.customerservice.finance.model;

import java.math.BigDecimal;

public class LineItemDto {

    private int product;

    private BigDecimal price;

    private int quantity;

    private BigDecimal discount;

    public int getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final LineItemDto lineItemDto;
        
        public Builder() {
            lineItemDto = new LineItemDto();
        }

        public Builder withProduct(int product) {
            lineItemDto.product = product;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            lineItemDto.price = price;
            return this;
        }

        public Builder withQuantity(int quantity) {
            lineItemDto.quantity = quantity;
            return this;
        }

        public Builder withDiscount(BigDecimal discount) {
            lineItemDto.discount = discount;
            return this;
        }

        public LineItemDto build() {
            return lineItemDto;
        }
    } 
}
