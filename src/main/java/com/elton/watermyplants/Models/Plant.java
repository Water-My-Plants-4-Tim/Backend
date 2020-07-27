package com.elton.watermyplants.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plants")
public class Plant
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


}
