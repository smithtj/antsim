package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import com.worldwarant.antsim.common.observer.EventManager;
import com.worldwarant.antsim.simulation.entities.resources.Resource;
import org.apache.commons.configuration2.Configuration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Chamber<T extends Resource> extends Structure {
    private volatile List<T> resources;
    private final Class<T> typeParam;
    private static final Logger logger = LogManager.getLogger(Chamber.class);

    public Chamber(EventManager eventManager, Configuration gameConfig, Class<T> typeParam) {
        super(eventManager, gameConfig, GameUtils.parseBySubset(gameConfig, "chamber").get("capacity"), new ArrayList<>());
        this.typeParam = typeParam;
    }

    public boolean hasFood() {
        return !resources.isEmpty();
    }

    public boolean isFull() {
        return resources.size() >= capacity;
    }

    @Override
    public String toString() {
        return null;
    }
}
