package com.elton.watermyplants.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<PlantLocation> plantLocations = new ArrayList<>();

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

    public List<PlantLocation> getPlantLocations()
    {
        return plantLocations;
    }

    public void setPlantLocations(List<PlantLocation> plantLocations)
    {
        this.plantLocations = plantLocations;
    }
}
