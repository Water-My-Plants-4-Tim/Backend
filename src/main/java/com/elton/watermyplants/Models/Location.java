package com.elton.watermyplants.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationid;

    private String name;

    @OneToMany(mappedBy = "location",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "cart",
            allowSetters = true)
    private List<PlantLocation> plantLocations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties(value = "carts",
            allowSetters = true)
    private User user;
}
