package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Plant;
import com.elton.watermyplants.Repos.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
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
    public Plant findProductById(long id)
    {
        return plantRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plant id " + id + " not found!"));
    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public Plant save(Plant plant)
    {
        if (plant.getPlantLocations()
                .size() > 0)
        {
            throw new EntityExistsException("Locatuons are not updated through Plants");
        }
        ;

        return plantRepo.save(plant);
    }
}
