package org.parasol.customerservice.finance.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends PanacheEntityBase {

    @Id
    @Column(name = "order_id")
    public int id;

    @Column(name = "customer_id")
    public String customer;

    @Column(name = "employee_id")
    public int employee;

    @Column(name = "order_date")
    public LocalDate orderDate;

    @Column(name = "required_date")
    public LocalDate requiredDate;

    @Column(name = "shipped_date")
    public LocalDate shippedDate;

    @Column(name = "ship_via")
    public int shipper;

    @Column(name = "freight", precision = 8, scale = 2, columnDefinition = "NUMERIC (8, 2)")
    public BigDecimal freight;

    @Column(name = "ship_name")
    public String shippingName;

    @Column(name = "ship_address")
    public String shippingAddress;

    @Column(name = "ship_city")
    public String shippingCity;

    @Column(name = "ship_region")
    public String shippingRegion;

    @Column(name = "ship_postal_code")
    public String shippingPostalCode;

    @Column(name = "ship_country")
    public String shippingCountry;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderLineItem> orderLineItems = new ArrayList<>();

}
