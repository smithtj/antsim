package com.worldwarant.antsim;

import com.worldwarant.antsim.common.RandomUtils;
import com.worldwarant.antsim.simulation.Simulator;
import com.worldwarant.antsim.common.GameUtils;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Program {

    private final static Logger logger = LogManager.getLogger(Program.class);

    public static void main(String[] args) {
        int durationInSeconds = getDurationFromArgsOrDefault(args, 30);
        seedRandom(args);
        runSimulation(durationInSeconds);
    }

    private static void seedRandom(String[] args) {
        if (hasNumericArgument(args, 1)) {
            RandomUtils.forceSetRandom(Integer.parseInt(args[1]));
        }
    }

    private static int getDurationFromArgsOrDefault(final String[] args, final int fallback) {
        return (hasNumericArgument(args, 0) ? fallback : Integer.parseInt(args[0]));
    }

    private static boolean hasNumericArgument(String[] args, int index) {
        int minLength = index + 1;
        return args != null && args.length >= minLength && args[index] != null && NumberUtils.isNumber(args[index]);
    }

    private static void runSimulation(int duration) {
        runSimulation(duration, "gameConfig.properties");
    }

    private static void runSimulation(int durationInSeconds, String gameConfig) {
        try {
            logger.log(Level.DEBUG, String.format("Trying to run simulation with properties from %S.", gameConfig));
            Configuration gameConfiguration = GameUtils.loadProperties(gameConfig);

            logger.log(Level.DEBUG, "Game configuration loaded.");
            logger.log(Level.DEBUG, "Creating simulator");

            Simulator antsim = new Simulator(gameConfiguration);

            logger.log(Level.DEBUG, "Starting to run simulation");
            antsim.runSimulation(durationInSeconds);

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
