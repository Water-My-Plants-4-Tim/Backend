package com.elton.watermyplants.Services;

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
        plantService.delete(1);
        assertEquals(2, plantService.findAll().size());
    }

    @Test
    void save()
    {
    }

    @Test
    void update()
    {
    }
}