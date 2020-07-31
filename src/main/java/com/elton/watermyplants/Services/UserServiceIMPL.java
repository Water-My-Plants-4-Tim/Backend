package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.*;
import com.elton.watermyplants.Repos.RoleRepo;
import com.elton.watermyplants.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceIMPL implements UserService
{

    @Autowired
    private PlantService plantService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepo userrepos;


    @Override
    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long id)
    {
        return userrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public void delete(long id)
    {
        userrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
        userrepos.deleteById(id);
    }

    @Override
    public User findByName(String name)
    {
        User uu = userrepos.findByUsername(name);
        if (uu == null)
        {
            throw new EntityNotFoundException("User not found!");
        }
        return uu;
    }

    @Override
    public User save(User user)
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userrepos.findById(user.getUserid())
                    .orElseThrow(() -> new EntityNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername());
        newUser.setPasswordNoEncrypt(user.getPassword());


        newUser.getRoles()
                .clear();
        for (UserRole ur : user.getRoles())
        {
            Role addRole = roleService.findRoleById(ur.getRole()
                    .getRoleid());
            newUser.getRoles()
                    .add(new UserRole(newUser, addRole));
        }

        newUser.getPlants().clear();
        for(UserPlants up: user.getPlants())
        {
            newUser.getPlants().add(new UserPlants(newUser,up.getPlants()));
        }

        return userrepos.save(newUser);

    }


    @Override
    public User update(User user, long id)
    {
        User currentUser = findUserById(id);

        if (user.getUsername() != null)
        {
            currentUser.setUsername(user.getUsername());
        }

        if (user.getPassword() != null)
        {
            currentUser.setPasswordNoEncrypt(user.getPassword());
        }

        return userrepos.save(currentUser);

    }
}
