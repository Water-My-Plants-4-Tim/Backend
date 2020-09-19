package com.elton.watermyplants.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "userplants")
@IdClass(UserPlantsId.class)
public class UserPlants extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "plants", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "plantid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Plant plants;


    public UserPlants()
    {

    }

    public UserPlants(User user, Plant plants)
    {
        this.user = user;
        this.plants = plants;
    }

    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    public Plant getPlants() {
        return plants;
    }
    public void setPlants(Plant plants)
    {
        this.plants = plants;
    }
    @Override
    public int hashCode()
    {
        return 37;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserPlants))
        {
            return false;
        }
        UserPlants that = (UserPlants) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
                ((plants == null) ? 0 : plants.getPlantid()) == ((that.plants == null) ? 0 : that.plants.getPlantid());
    }


}