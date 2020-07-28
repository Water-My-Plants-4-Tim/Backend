package com.elton.watermyplants;


import com.elton.watermyplants.Models.*;
import com.elton.watermyplants.Repos.LocationRepo;
import com.elton.watermyplants.Services.LocationService;
import com.elton.watermyplants.Services.PlantService;
import com.elton.watermyplants.Services.RoleService;
import com.elton.watermyplants.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Transactional
@Component
public class SeedData
        implements CommandLineRunner
{
        @Autowired
    LocationService locationService;

        @Autowired
    RoleService roleService;
        @Autowired
    UserService userService;

        @Autowired
    PlantService plantService;

        @Autowired
    LocationRepo locationRepo;


    @Override
    public void run(String[] args) throws Exception
    {

        /************
         * Seed Users
         * ************/
        // work on this later
//        userService.deleteAll();
//        roleService.deleteAll();
//        plantService.deleteAll();

        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);

        Plant p1 = new Plant("once a week", "happy plant", "money tree");
        Plant p2 = new Plant("twice a week", "better luck next time", "fiddle leaf fig");
        Plant p3 = new Plant("one a month", "susie", "creeping jenny");

        Location l1 = new Location("inside");
        Location l2 = new Location("outside");

        l1 = locationRepo.save(l1);
        l2 =locationRepo.save(l2);

        p1.getPlantLocations().add(new PlantLocation(l1, p1));
        p1.getPlantLocations().add(new PlantLocation(l2, p1));

        System.out.println(p1.getPlantLocations().size());

        p1 = plantService.save(p1);
        p2 = plantService.save(p2);
        p3 = plantService.save(p3);

        Set<UserRole> admins = new HashSet<>();
        // admins
        User u1 = new User("Gracee", "password");
        u1.getRoles()
                .add(new UserRole(u1, r1));
        User u2 = new User("Sarah", "password");
        u2.getRoles()
                .add(new UserRole(u2, r2));


        u1 = userService.save(u1);
        u2 =userService.save(u2);

        // users
        Set<UserRole> users = new HashSet<>();
        User u3 = new User("User","password");
        u1.getRoles()
                .add(new UserRole(u1, r2));
        u3 = userService.save(u3);


        System.out.println("hello");
    }
}
