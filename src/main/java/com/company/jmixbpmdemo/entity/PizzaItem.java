package com.company.jmixbpmdemo.entity;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JmixEntity
@Table(name = "PIZZA_ITEM")
@Entity
public class PizzaItem {

    @InstanceName
    @Column(name = "ID", nullable = false)
    @Id
    private String id;
    @Column(name = "PRICE")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}