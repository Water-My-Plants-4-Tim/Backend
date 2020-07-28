package com.elton.watermyplants.Contollers;

import com.elton.watermyplants.Models.Location;
import com.elton.watermyplants.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController
{
    //Get - http:// localhost:2019/locations/user/2

//    @Autowired
//    private LocationService locationService;
//
//    @GetMapping(value = "/user/{userid}", produces = {"application/json"})
//    public ResponseEntity<?> listAllLoations(@PathVariable long userid)
//    {
//        List<Location> myLocations = locationService.findAllByUserId(userid);
//    }

}
