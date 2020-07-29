package com.elton.watermyplants.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plants")
public class Plant extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantid;

    @Column(nullable = false,
            unique = true)
    private String frequency;

    @Column
    private String nickname;

    @Column
    private String location;

    @Column(nullable = false,
            unique = true)
    private String species;

    @OneToMany(mappedBy = "plants",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "plants",
            allowSetters = true)
    private Set<UserPlants> usersPlants = new HashSet<>();


    public Plant()
    {
    }

    public Plant(String frequency, String nickname, String location, String species)
    {
        this.frequency = frequency;
        this.nickname = nickname;
        this.location = location;
        this.species = species;
    }

    public long getPlantid()
    {
        return plantid;
    }

    public void setPlantid(long plantid)
    {
        this.plantid = plantid;
    }

    public String getFrequency()
    {
        return frequency;
    }

    public void setFrequency(String frequency)
    {
        this.frequency = frequency;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getSpecies()
    {
        return species;
    }

    public void setSpecies(String species)
    {
        this.species = species;
    }

    public Set<UserPlants> getUsersPlants()
    {
        return usersPlants;
    }

    public void setUsersPlants(Set<UserPlants> usersPlants)
    {
        this.usersPlants = usersPlants;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}