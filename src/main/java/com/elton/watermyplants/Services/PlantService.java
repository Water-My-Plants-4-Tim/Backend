package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Plant;


import java.util.List;

public interface PlantService
{
    List<Plant>findAll();

    Plant findProductById(long id);

    void delete(long id);

    Plant save(Plant product);

}
