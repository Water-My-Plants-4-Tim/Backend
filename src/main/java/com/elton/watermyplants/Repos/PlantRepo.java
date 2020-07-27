package com.elton.watermyplants.Repos;

import com.elton.watermyplants.Models.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepo extends CrudRepository<Plant, Long>
{

}
