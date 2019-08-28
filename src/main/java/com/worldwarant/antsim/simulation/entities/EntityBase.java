package com.worldwarant.antsim.simulation.entities;

import org.apache.commons.configuration2.Configuration;

public abstract class EntityBase {

    private final Configuration gameConfig;

    public EntityBase(Configuration gameConfig) {
        this.gameConfig = gameConfig;
    }

    @Override
    public abstract String toString();
}
