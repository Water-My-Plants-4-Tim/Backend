package com.elton.watermyplants.Models;

import java.io.Serializable;
import java.util.Objects;

public class PlantLocationId
        implements Serializable
{

    private long location;

    private long plant;

    public PlantLocationId()
    {
    }

    public long getLocation()
    {
        return location;
    }

    public void setLocation(long location)
    {
        this.location = location;
    }

    public long getPlant()
    {
        return plant;
    }

    public void setPlant(long plant)
    {
        this.plant = plant;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantLocationId that = (PlantLocationId) o;
        return location == that.location &&
                plant == that.plant;
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(location, plant);
        return 37;
    }
}
