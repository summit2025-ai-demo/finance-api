package org.parasol.customerservice.finance.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderLineItem extends PanacheEntityBase {

    @Id
    @Column(name = "order_detail_id")
    public int id;

    @Column(name = "product_id")
    public int product;

    @Column(name = "unit_price", precision = 8, scale = 2, columnDefinition = "NUMERIC (8, 2)")
    public BigDecimal price;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "discount", precision = 8, scale = 2, columnDefinition = "NUMERIC (8, 2)")
    public BigDecimal discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    public Order order;
}
