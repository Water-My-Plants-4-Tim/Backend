package com.elton.watermyplants.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "plantlocations")
@IdClass(PlantLocationId.class)
public class PlantLocation extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "locationid")
    @JsonIgnoreProperties(value = "plants", allowSetters = true)
    private Location location;

    @Id
    @ManyToOne
    @JoinColumn(name = "plantid")
    @JsonIgnoreProperties(value = "locations", allowSetters = true)
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
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof PlantLocation))
        {
            return false;
        }
        PlantLocation that = (PlantLocation) o;
        return ((plant == null) ? 0 : plant.getPlantid()) == ((that.plant == null) ? 0 : that.plant.getPlantid()) &&
                ((location == null) ? 0 : location.getLocationid()) == ((that.location == null) ? 0 : that.location.getLocationid());
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(location, plant);
        return 37;
    }


}
