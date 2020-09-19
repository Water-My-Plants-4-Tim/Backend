package com.elton.watermyplants.Repos;

import com.elton.watermyplants.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>
{
    User findByUsername(String username);

}
