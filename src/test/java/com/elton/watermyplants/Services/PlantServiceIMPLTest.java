package com.elton.watermyplants.Services;

import com.elton.watermyplants.Models.Plant;
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

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WatermyplantsApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PlantServiceIMPLTest
{

    @Autowired
    private PlantService plantService;

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
    void findAll()
    {
        assertEquals(3,plantService.findAll().size());

    }

    @Test
    void findPlantById()
    {
        assertEquals("happy plant", plantService.findPlantById(1).getNickname());

    }

    @Test
    void delete()
    {
        plantService.delete(3);
        assertEquals(2, plantService.findAll().size());
    }

    @Test
    void save()
    {
        //this.frequency = frequency;
        //        this.nickname = nickname;
        //        this.location = location;
        //        this.species = species;

        Plant newPlant = new Plant("loser","loser","loser", "loser");

        Plant addPlant = plantService.save((newPlant));
        assertNotNull(addPlant);

        Plant foundPlant = plantService.findPlantById(addPlant.getPlantid());
        assertEquals(addPlant.getNickname(),foundPlant.getNickname());

    }

    @Test
    void update()
    {
        Plant newPlant = new Plant("loser","loser","loser", "loser");

        Plant updatePlant = plantService.update(newPlant, 1);
        assertEquals("loser",updatePlant.getNickname());
    }
}