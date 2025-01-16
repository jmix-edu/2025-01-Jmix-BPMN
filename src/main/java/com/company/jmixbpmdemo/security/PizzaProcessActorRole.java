package com.company.jmixbpmdemo.security;

import com.company.jmixbpmdemo.entity.OrderLine;
import com.company.jmixbpmdemo.entity.PizzaItem;
import com.company.jmixbpmdemo.entity.PizzaOrder;
import com.company.jmixbpmdemo.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "PizzaProcessActor", code = PizzaProcessActorRole.CODE, scope = "UI")
public interface PizzaProcessActorRole {
    String CODE = "pizza-process-actor";

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.ALL)
    void user();

    @ViewPolicy(viewIds = {"User.list", "PizzaItem.list", "PizzaProcessStartForm", "SelectPizzaForm", "ServiceTasksStartForm"})
    void screens();

    @EntityAttributePolicy(entityClass = OrderLine.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = OrderLine.class, actions = EntityPolicyAction.ALL)
    void orderLine();

    @EntityAttributePolicy(entityClass = PizzaItem.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = PizzaItem.class, actions = EntityPolicyAction.ALL)
    void pizzaItem();

    @EntityAttributePolicy(entityClass = PizzaOrder.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = PizzaOrder.class, actions = EntityPolicyAction.ALL)
    void pizzaOrder();
}