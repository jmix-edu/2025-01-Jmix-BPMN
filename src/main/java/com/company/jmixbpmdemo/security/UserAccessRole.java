package com.company.jmixbpmdemo.security;

import com.company.jmixbpmdemo.entity.User;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "UserAccessRole", code = UserAccessRole.CODE)
public interface UserAccessRole {
    String CODE = "user-access-role";

    @JpqlRowLevelPolicy(entityClass = User.class, where = "{E}.username <> 'admin'")
    void user();
}