package com.worldwarant.antsim.simulation;

import com.worldwarant.antsim.simulation.entities.World;
import org.apache.commons.configuration2.Configuration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Simulator {
    private final Configuration gameConfig;
    private static final Logger logger = LogManager.getLogger(Simulator.class);
    private World gameWorld;

    public Simulator(Configuration gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void runSimulation(int duration) {
        logger.log(Level.ALL, "Simulation successful.");
        System.out.println("Hello sim.");
    }

    public void initialiseSimulation() throws SimulationException {
        World gameWorld = World.getInstance();
        synchronized(gameWorld) {
            if (gameWorld.canModify()) {
                if (gameWorld.tryInitialiseGameWorld(gameConfig)) {
                    throw new SimulationException("Unable to initiate simulation");
                }
            }
        }
    }
}
