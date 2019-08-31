package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import com.worldwarant.antsim.simulation.entities.resources.Egg;
import com.worldwarant.antsim.simulation.entities.resources.Remains;
import com.worldwarant.antsim.simulation.entities.resources.Vegetation;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NestTests {

    static Configuration gameConfig;
    static Nest nest;
    @BeforeAll
    static void initAll() {
        try {
            gameConfig = GameUtils.loadProperties("gameConfig.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void createNest() {
        nest = new Nest(gameConfig);
    }

    @DisplayName("Nest should contain a list of structures as per config.")
    @Test
    void nestContainsConfigStructures() {

        //act
        int nestChamberCount = (int)nest.nestStructures.stream().filter(Chamber.class::isInstance).count();
        int nestFoodPileCount = (int)nest.nestStructures.stream().filter(FoodPile.class::isInstance).count();

        int expectedChamberCount = Arrays.asList(Egg.class, Remains.class, Vegetation.class).size();
        int expectedFoodPileCount = 1;

        //assert

        assertEquals(nestChamberCount, expectedChamberCount);
        assertEquals(nestFoodPileCount, expectedFoodPileCount);

    }

    @DisplayName("Nest contains a non-null structure list once initiated")
    @Test
    void nestStructuresNotNull() {
        assertTrue(nest.nestStructures != null);
        assertTrue(nest.nestStructures.size() > 0);
    }
}
