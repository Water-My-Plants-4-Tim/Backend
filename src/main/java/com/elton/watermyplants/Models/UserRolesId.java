package com.elton.watermyplants.Models;

import java.io.Serializable;


/**
 * Class to represent the complex primary key for UserRoles
 */
public class UserRolesId
        implements Serializable
{
    /**
     * The id of the user
     */
    private long user;

    /**
     * The id of the role
     */
    private long role;

    /**
     * The default constructor required by JPA
     */
    public UserRolesId()
    {
    }


    public long getUser()
    {
        return user;
    }

    public void setUser(long user)
    {
        this.user = user;
    }

    public long getRole()
    {
        return role;
    }

    public void setRole(long role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRolesId that = (UserRolesId) o;
        return user == that.user &&
                role == that.role;
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(user, role);
        return 37;
    }
}
