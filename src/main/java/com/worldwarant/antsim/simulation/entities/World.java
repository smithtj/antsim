package com.worldwarant.antsim.simulation.entities;

import org.apache.commons.configuration2.Configuration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class World {

    private static volatile World instance;
    private final Configuration config;
    private static final Logger logger = LogManager.getLogger(World.class);

    private List<WorkerAnt> workers;
    private List<WarriorAnt> warriors;
    private List<QueenAnt> queens;

    private World(Configuration gameConfig)
    {
        logger.log(Level.DEBUG, "World instance created.");
        this.config = gameConfig;
        initialiseWorld();
    }

    private void initialiseWorld() {
        workers = initialiseAnts(WorkerAnt.class);
        warriors = initialiseAnts(WarriorAnt.class);
        queens = initialiseAnts(QueenAnt.class);
    }

    public static World getInstance(Configuration gameConfig) {
        World result = instance;
        if (result == null) {
            synchronized(World.class) {
                result = instance;
                if (result == null) {
                    instance = result = new World(gameConfig);
                }
            }
        }
        return result;
    }

    public List<WorkerAnt> getWorkers() {
        return this.workers;
    }

    public List<WarriorAnt> getWarriors() {
        return this.warriors;
    }

    public List<QueenAnt> getQueens() {
        return this.queens;
    }

    private <T extends EntityBase> T newEntity(Class<T> entityType) {
        try {
            return entityType.asSubclass(entityType).getConstructor(Configuration.class).newInstance(config);
        } catch (Exception e) {
            logger.log(Level.ERROR, "Failed to instantiate " + entityType);
            throw new RuntimeException(e);
        }
    }

    private <T extends EntityBase> List<T> newEntities(Class<T> entityType, int quantity) {
        return IntStream.range(0, quantity).mapToObj(o -> newEntity(entityType)).collect(Collectors.toList());
    }

    private <T extends AntBase> List<T> initialiseAnts(Class<T> antType) {
        String antTypeName = getAntName(antType);
        int workerQuantity = config.getInt(
                String.format("ants.%s.quantity", antTypeName)
                );
        logger.log(Level.DEBUG, String.format("World initialising %d %s.", workerQuantity, antTypeName));
        List<T> ants = newEntities(antType, workerQuantity);
        return ants;
    }

    private <T extends AntBase> String getAntName(Class<T> antType) {
        String fullAntName = antType.getSimpleName();
        String antName = fullAntName.replaceFirst("Ant", "").toLowerCase();
        return antName;
    }
}
