package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.User;
import com.elton.watermyplants.Models.UserPlants;
import com.elton.watermyplants.Models.UserRole;
import com.elton.watermyplants.WatermyplantsApplication;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// all test work - 85%
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WatermyplantsApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserServiceIMPLTest
{

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);

    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void a_findAll()
    {
        assertEquals(3,userService.findAll().size());
    }

    //working
    @Test
    void b_findUserById()
    {
        assertEquals("Sarah", userService.findUserById(8).getUsername());

    }

    @Test
    void c_findByName()
    {
    }


    @Test
    void d_delete()
    {
        userService.delete(9);
        assertEquals(3, userService.findAll().size());
    }


    @Test
    void e_save()
    {
        // setUsername(username);
        //        setPassword(password);
        //        this.roles = roles;
        //        this.plants = plants;

        Set<UserPlants> userplants = new HashSet<>();
        Set<UserRole> roles = new HashSet<>();

        User newuser = new User("newuser","password",roles,userplants);

        User addUser = userService.save(newuser);
        assertNotNull(addUser);

        User foundUser = userService.findUserById(addUser.getUserid());
        assertEquals(addUser.getUsername(),foundUser.getUsername());
    }

    @Test
    void f_update()
    {
        Set<UserPlants> userplants = new HashSet<>();
        Set<UserRole> roles = new HashSet<>();

        User newuser = new User("Jo test","password",roles,userplants);

        User updateUser = userService.update(newuser, 6);
        assertEquals("Jo test", updateUser.getUsername());

    }
}