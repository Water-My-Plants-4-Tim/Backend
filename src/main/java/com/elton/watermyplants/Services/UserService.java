package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User findByName(String name);
}
