package com.elton.watermyplants.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationid;

    private String name;

    @OneToMany(mappedBy = "location",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "cart",
            allowSetters = true)
    private Set<PlantLocation> plantLocations = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties(value = "carts",
            allowSetters = true)
    private User user;

    public Location()
    {
    }

    public Location(String name)
    {
        this.name = name;
    }

    public long getLocationid()
    {
        return locationid;
    }

    public void setLocationid(long locationid)
    {
        this.locationid = locationid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<PlantLocation> getPlantLocations()
    {
        return plantLocations;
    }

    public void setPlantLocations(Set<PlantLocation> plantLocations)
    {
        this.plantLocations = plantLocations;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
