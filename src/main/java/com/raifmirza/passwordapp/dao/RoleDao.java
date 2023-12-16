package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String roleName);
}
