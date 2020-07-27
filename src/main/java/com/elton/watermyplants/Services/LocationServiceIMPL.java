package com.elton.watermyplants.Services;


import com.elton.watermyplants.Models.Location;
import com.elton.watermyplants.Models.Plant;
import com.elton.watermyplants.Models.PlantLocation;
import com.elton.watermyplants.Models.User;
import com.elton.watermyplants.Repos.LocationRepo;
import com.elton.watermyplants.Repos.PlantRepo;
import com.elton.watermyplants.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service(value = "locationService")
public class LocationServiceIMPL implements LocationService
{

    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private UserRepo userrepos;
    @Autowired
    private PlantRepo plantRepo;

    @Override
    public List<Location> findAllByUserId(Long userid)
    {
        return null;
    }

    @Override
    public Location findLocationById(long id)
    {
        return locationRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car id " + id + " not found!"));
    }

    @Override
    public Location save(User user, Plant plant)
    {
        Location newLocation = new Location();

        User dbuser = userrepos.findById(user.getUserid())
                .orElseThrow(() -> new EntityNotFoundException("User id " + user.getUserid() + " not found"));
        newLocation.setUser(dbuser);

        Plant dbplant = plantRepo.findById(plant.getPlanttid())
                .orElseThrow(() -> new EntityNotFoundException("Plant id " + plant.getPlanttid() + " not found"));

        PlantLocation newPlantLocation = new PlantLocation();
        newPlantLocation.setLocation(newLocation);
        newPlantLocation.setPlant(dbplant);
        newLocation.getPlantLocations()
                .add(newPlantLocation);

        return locationRepo.save(newLocation);
    }

    @Override
    public Location save(Location location, Plant plant)
    {
       return null;
    }

    @Override
    public void delete(Location location, Plant plant)
    {

    }
}
