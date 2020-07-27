package com.elton.watermyplants.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "plantlocation")
public class PlantLocation extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "locationid")
    @JsonIgnoreProperties(value = "plants")
    private Location location;

    @Id
    @ManyToOne
    @JoinColumn(name = "plantid")
    @JsonIgnoreProperties(value = "locationss")
    private Plant plant;

    public PlantLocation()
    {
    }

    public PlantLocation(Location location, Plant plant)
    {
        this.location = location;
        this.plant = plant;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public Plant getPlant()
    {
        return plant;
    }

    public void setPlant(Plant plant)
    {
        this.plant = plant;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(location,
                plant);
    }
}
