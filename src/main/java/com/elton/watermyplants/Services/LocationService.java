package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Location;
import com.elton.watermyplants.Models.Plant;
import com.elton.watermyplants.Models.User;

import java.util.List;

public interface LocationService
{

    List<Location> findall();

    List<Location> findAllByUserId(Long userid);

    Location findById(long id);

    Location save(User user,
                  Plant plant);

    Location save(Location location,
                  Plant plant);


    void delete(Location location,
                Plant plant);

}
