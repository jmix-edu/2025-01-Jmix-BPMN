package com.company.jmixbpmdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@JmixEntity
@Table(name = "ORDER_LINE", indexes = {
        @Index(name = "IDX_ORDER_LINE_PIZZA_ITEM", columnList = "PIZZA_ITEM_ID"),
        @Index(name = "IDX_ORDER_LINE_PIZZA_EATER", columnList = "PIZZA_EATER_ID"),
        @Index(name = "IDX_ORDER_LINE_PIZZA_ORDER", columnList = "PIZZA_ORDER_ID")
})
@Entity
public class OrderLine {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;
    @JoinColumn(name = "PIZZA_ITEM_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private PizzaItem pizzaItem;
    @Column(name = "SPECIAL_REQUIREMENTS")
    private String specialRequirements;
    @JoinColumn(name = "PIZZA_EATER_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User pizzaEater;
    @JoinColumn(name = "PIZZA_ORDER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PizzaOrder pizzaOrder;

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public User getPizzaEater() {
        return pizzaEater;
    }

    public void setPizzaEater(User pizzaEater) {
        this.pizzaEater = pizzaEater;
    }

    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public PizzaItem getPizzaItem() {
        return pizzaItem;
    }

    public void setPizzaItem(PizzaItem pizzaItem) {
        this.pizzaItem = pizzaItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}