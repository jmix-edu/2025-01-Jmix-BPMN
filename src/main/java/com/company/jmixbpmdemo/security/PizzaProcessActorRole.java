package com.company.jmixbpmdemo.security;

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

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();

    @ViewPolicy(viewIds = "User.list")
    void screens();
}