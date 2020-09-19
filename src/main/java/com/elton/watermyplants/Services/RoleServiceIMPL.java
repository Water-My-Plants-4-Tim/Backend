package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Role;
import com.elton.watermyplants.Models.User;
import com.elton.watermyplants.Models.UserRole;
import com.elton.watermyplants.Repos.RoleRepo;
import com.elton.watermyplants.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "roleService")
public class RoleServiceIMPL implements RoleService
{

    @Autowired
    private UserRepo userrepos;

    @Autowired
    private RoleRepo rolerepos;

    @Override
    public List<Role> findAll()
    {
        List<Role> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        rolerepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Role findRoleById(long id)
    {
        return rolerepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role id " + id + " not found!"));
    }

    @Override
    public Role save(Role role)
    {
        if (role.getUsers()
                .size() > 0)
        {
            throw new EntityNotFoundException("User Roles are not updated through Role.");
        }

        return rolerepos.save(role);
    }

    @Override
    public void delete(long id)
    {
        rolerepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role id " + id + " not found!"));
        rolerepos.deleteById(id);
    }

    @Override
    public Role findByName(String name)
    {
        Role rr = rolerepos.findByName(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new EntityNotFoundException(name);
        }
    }

    @Override
    public Role update(long id, Role role)
    {
        return null;
    }
}
