package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Location;
import com.elton.watermyplants.Models.Plant;


import java.util.List;

public interface PlantService
{
    List<Plant>findAll();

    Plant findLocationById(long id);

    void delete(long id);

    Plant save(Plant plant);

}
