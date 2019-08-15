package com.worldwarant.antsim;

import com.worldwarant.antsim.simulation.Simulator;
import com.worldwarant.antsim.common.GameUtils;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Program {

    private final static Logger logger = LogManager.getLogger(Program.class);

    public static void main(String[] args) {
        runSimulation();
    }

    public static void runSimulation() {
        runSimulation("gameConfig.properties");
    }

    public static void runSimulation(String gameConfig) {
        try {
            logger.log(Level.DEBUG, String.format("Trying to run simulation with properties from %S.", gameConfig));
            Configuration gameConfiguration = GameUtils.loadProperties(gameConfig);
            logger.log(Level.DEBUG, "Game configuration loaded.");
            logger.log(Level.DEBUG, "Creating simulator");
            Simulator antsim = new Simulator(gameConfiguration);
            logger.log(Level.DEBUG, "Starting to run simulation");
            antsim.runSimulation();
        } catch (ConfigurationException e) {
            logger.log(Level.ERROR, "Configuration failed.");
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            logger.log(Level.ERROR, "Simulation failed!");
            logger.log(Level.ERROR, "The ants died of dysentery.");
            logger.log(Level.ERROR, e.getMessage());
        }

    }
}
