package com.elton.watermyplants.Contollers;


import com.elton.watermyplants.Models.Plant;
import com.elton.watermyplants.Models.User;
import com.elton.watermyplants.Models.UserPlants;
import com.elton.watermyplants.Services.PlantService;
import com.elton.watermyplants.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController
{
    @Autowired
    private UserService userService;

    @Autowired
    private PlantService plantService;

    // add new plant
    // not working but i think we are getting there
    @PostMapping(value = "/users/plants", produces = {"application/json"})
    public ResponseEntity<?> listPlants(Authentication authentication, @Valid @RequestBody Plant newplant)
    {
        User u = userService.findByName(authentication.getName());
        newplant.setPlantid(0);
        newplant.getUsersPlants().add(new UserPlants(u ,newplant));
        newplant = plantService.save(newplant);
        return new ResponseEntity<>(  null, HttpStatus.CREATED );
    }

    // Working
    @PutMapping(value = "/users/plants/{plantid}",
            consumes = "application/json")
    public ResponseEntity<?> updatePlant(Authentication authentication,
            @Valid
            @RequestBody
                    Plant updatePlant,
            @PathVariable
                    long plantid)
    {
        User u = userService.findByName(authentication.getName());
        updatePlant.setPlantid(plantid);
        plantService.update(updatePlant, plantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // not working ugghhgghhgghh it says can't find plant? Weird?
    @DeleteMapping(value = "/user/plant/plantid")
    public ResponseEntity<?> deleteUserById(Authentication authentication , @PathVariable long plantid)
    {
        User u = userService.findByName(authentication.getName());
        plantService.delete(plantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
