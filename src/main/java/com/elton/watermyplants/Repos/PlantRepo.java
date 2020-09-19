package com.elton.watermyplants.Repos;

import com.elton.watermyplants.Models.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepo extends CrudRepository<Plant, Long>
{

}
