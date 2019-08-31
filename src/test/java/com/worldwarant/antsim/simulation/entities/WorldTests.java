package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorldTests {

    static Configuration gameConfig;
    @BeforeAll
    static void initAll() {
        try {
            gameConfig = GameUtils.loadProperties("gameConfig.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }

    @DisplayName("Multiple instances of world should be same object.")
    @Test
    void worldIsSingletonTest() {
        World world1 = World.getInstance();
        World world2 = World.getInstance();

        assertEquals(world1, world2);
    }

    @DisplayName("Size of world ant lists should match qusntities in configuration")
    @Test
    void worldAntsQuantitiesMatchConfig() {
        //arrange
        World newWorld = World.getInstance();
        newWorld.tryInitialiseGameWorld(gameConfig);

        //act
        int workerConfigQty = gameConfig.getInt("ants.worker.quantity");
        int queenConfigQty = gameConfig.getInt("ants.queen.quantity");
        int warriorConfigQty = gameConfig.getInt("ants.warrior.quantity");

        int workerWorldQty = newWorld.getWorkers().size();
        int queenWorldQty = newWorld.getQueens().size();
        int warriorWorldQty = newWorld.getWarriors().size();

        //assert
        assertEquals(workerConfigQty, workerWorldQty);
        assertEquals(queenConfigQty, queenWorldQty);
        assertEquals(warriorConfigQty, warriorWorldQty);
    }

}
