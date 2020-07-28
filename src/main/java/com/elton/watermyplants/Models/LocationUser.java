package com.elton.watermyplants.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "locationUser")
public class LocationUser extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationuserid;

    @Column(nullable = false)
    private String locationuser;

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties(value = "carts",
            allowSetters = true)
    private User user;

    public LocationUser()
    {
    }

    public LocationUser(String locationuser, User user)
    {
        this.locationuser = locationuser;
        this.user = user;
    }

    public long getLocationuserid()
    {
        return locationuserid;
    }

    public void setLocationuserid(long locationuserid)
    {
        this.locationuserid = locationuserid;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getLocationuser()
    {
        return locationuser;
    }

    public void setLocationuser(String locationuser)
    {
        this.locationuser = locationuser;
    }
}
