package com.company.jmixbpmdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@JmixEntity
@Table(name = "PIZZA_ORDER", indexes = {
        @Index(name = "IDX_PIZZA_ORDER_INITIATIOR", columnList = "INITIATIOR_ID"),
        @Index(name = "IDX_PIZZA_ORDER_APPROVER", columnList = "APPROVER_ID")
})
@Entity
public class PizzaOrder {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;
    @OneToMany(mappedBy = "pizzaOrder")
    private List<OrderLine> orderLines;
    @JoinColumn(name = "INITIATIOR_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User initiatior;
    @JoinColumn(name = "APPROVER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User approver;
    @NotNull
    @Column(name = "DELIVERY_NUMBER", nullable = false)
    private String deliveryNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OPENED")
    private Date opened;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CLOSED")
    private Date closed;

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    public User getInitiatior() {
        return initiatior;
    }

    public void setInitiatior(User initiatior) {
        this.initiatior = initiatior;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}