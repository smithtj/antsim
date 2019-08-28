package com.worldwarant.antsim.simulation;

import org.apache.commons.configuration2.Configuration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Simulator {
    private final Configuration gameConfig;
    private static final Logger logger = LogManager.getLogger(Simulator.class);

    public Simulator(Configuration gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void runSimulation() {
        logger.log(Level.ALL, "Simulation successful.");
        System.out.println("Hello sim.");
    }

    public void initialiseSimulation() {

    }
}
