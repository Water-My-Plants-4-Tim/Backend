package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Role;

import java.util.List;

public interface RoleService
{
    List<Role> findAll();

    Role findRoleById(long id);

    Role save(Role role);

    void delete(long id);

    Role update(
            long id,
            Role role);
}
