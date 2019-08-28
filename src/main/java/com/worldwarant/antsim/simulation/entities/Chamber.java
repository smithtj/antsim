package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.observer.EventManager;
import org.apache.commons.configuration2.Configuration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Chamber<T> extends Structure {
    private volatile List<T> resources;
    private final Class<T> typeParam;
    private static final Logger logger = LogManager.getLogger(Chamber.class);
    private final int capacity;

    public Chamber(EventManager eventManager, Configuration gameConfig, Class<T> typeParam) {
        super(eventManager, gameConfig);
        resources = new ArrayList<>();
        this.typeParam = typeParam;
        capacity = this.gameConfig.getInt("chamber.capacity");
    }

    public boolean hasFood() {
        return !resources.isEmpty();
    }

    public void deposit(T resource) {
        logger.log(Level.DEBUG, String.format("Resource %s has been deposited in chamber", typeParam.toGenericString()));
        resources.add(resource);
    }

    public boolean isFull() {
        return resources.size() >= capacity;
    }

    @Override
    public String toString() {
        return null;
    }
}
