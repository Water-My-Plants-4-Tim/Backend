package com.elton.watermyplants;


import com.elton.watermyplants.Models.*;
import com.elton.watermyplants.Services.PlantService;
import com.elton.watermyplants.Services.RoleService;
import com.elton.watermyplants.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData
        implements CommandLineRunner
{


    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    PlantService plantService;

    // need to add plants to users
    @Override
    public void run(String[] args) throws Exception
    {

        /************
         * Seed Users
         * ************/


        Plant p1 = new Plant("once a week", "happy plant","Living  room", "money tree");
        Plant p2 = new Plant("twice a week", "better luck next time","Living  room" ,"fiddle leaf fig");
        Plant p3 = new Plant("once a month", "susie", "Living  room","creeping jenny");

        p1 = plantService.save(p1);
        p2 = plantService.save(p2);
        p3 = plantService.save(p3);


        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);

        User u1 = new User("testGracee", "password");
        u1.getRoles()
                .add(new UserRole(u1, r1));
        u1.getPlants().add(new UserPlants(u1,p1));

        User u2 = new User("Sarah", "password");
        u2.getRoles()
                .add(new UserRole(u2, r2));
        u2.getPlants().add(new UserPlants(u2,p2));


        User u3 = new User("User","password");
        u3.getRoles()
                .add(new UserRole(u1, r2));
        u3.getPlants().add(new UserPlants(u1,p1));
        u3.getPlants().add(new UserPlants(u1,p3));


        u3 = userService.save(u3);
        u1 = userService.save(u1);
        u2 = userService.save(u2);

        System.out.println("hello");
    }
}
