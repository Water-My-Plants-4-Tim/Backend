package com.elton.watermyplants.Repos;

import com.elton.watermyplants.Models.Role;
import com.elton.watermyplants.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long>
{
   Role findByName(String name);
}
