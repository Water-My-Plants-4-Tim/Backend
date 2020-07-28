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
    private long planttid;


    private String frequency;
    private String nickname;
    private String species;

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "product",
            allowSetters = true)
    private Set<PlantLocation> plantLocations = new HashSet<>();

    public Plant()
    {
    }

    public Plant(String frequency, String nickname, String species)
    {
        this.frequency = frequency;
        this.nickname = nickname;
        this.species = species;
    }

    public long getPlanttid()
    {
        return planttid;
    }

    public void setPlanttid(long planttid)
    {
        this.planttid = planttid;
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

    public Set<PlantLocation> getPlantLocations()
    {
        return plantLocations;
    }

    public void setPlantLocations(Set<PlantLocation> plantLocations)
    {
        this.plantLocations = plantLocations;
    }

    public void add(PlantLocation newPlantLocation)
    {

    }
}
