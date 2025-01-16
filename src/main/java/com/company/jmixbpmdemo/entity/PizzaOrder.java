package com.company.jmixbpmdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JmixEntity
@Table(name = "PIZZA_ORDER", indexes = {
        @Index(name = "IDX_PIZZA_ORDER_APPROVER", columnList = "APPROVER_ID")
})
@Entity
public class PizzaOrder {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;
    @OneToMany(mappedBy = "pizzaOrder")
    private List<OrderLine> orderLines;
    @JoinColumn(name = "APPROVER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User approver;
    @Column(name = "DELIVERY_NUMBER")
    private String deliveryNumber;
    @Column(name = "APPROVED", nullable = false)
    @NotNull
    private Boolean approved = false;
    @Column(name = "REJECTED", nullable = false)
    @NotNull
    private Boolean rejected = false;

    public Boolean getRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
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