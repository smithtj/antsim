package com.worldwarant.antsim.simulation.entities;

import org.apache.commons.configuration2.Configuration;

public abstract class EntityBase {

    protected final Configuration gameConfig;

    protected EntityBase(Configuration gameConfig) {
        this.gameConfig = gameConfig;
    }

    @Override
    public abstract String toString();
}
