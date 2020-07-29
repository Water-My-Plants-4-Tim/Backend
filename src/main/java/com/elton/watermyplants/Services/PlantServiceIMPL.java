package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Plant;
import com.elton.watermyplants.Repos.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "plantService")
public class PlantServiceIMPL implements PlantService
{


    @Autowired
    private PlantRepo plantRepo;

    @Override
    public List<Plant> findAll()
    {
        List<Plant> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        plantRepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Plant findPlantById(long id)
    {
        return plantRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plant id " + id + " not found!"));
    }

    @Override
    public void delete(long id)
    {
        plantRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Plant " + id + " not found!"));
        plantRepo.deleteById(id);

    }


    @Transactional
    @Override
    public Plant save(Plant plant)
    {
        return plantRepo.save(plant);
    }

    @Override
    public Plant update(Plant plant, long id)
    {
        Plant currentPlant = findPlantById(id);

        if(plant.getFrequency()!=null)
        {
            currentPlant.setFrequency(plant.getFrequency());
        }
        if(plant.getLocation()!=null)
        {
            currentPlant.setLocation(plant.getLocation());
        }
        if(plant.getSpecies()!=null)
        {
            currentPlant.setSpecies(plant.getSpecies());

        }
        if(plant.getNickname()!=null)
        {
            currentPlant.setNickname(plant.getNickname());
        }

        return plantRepo.save(currentPlant);

    }


}
