package com.customer.manager.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Order.
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "price")
    private Long price;



    @ManyToOne
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public Order orderName(String orderName) {
        this.orderName = orderName;
        return this;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Long getPrice() {
        return price;
    }

    public Order price(Long price) {
        this.price = price;
        return this;
    }

    public void setPrice(Long price) {
        this.price = price;
    }



    public Customer getCustomer() {
        return customer;
    }

    public Order customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return id != null && id.equals(((Order) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", orderName='" + getOrderName() + "'" +
            ", price=" + getPrice() +
            "}";
    }
}
