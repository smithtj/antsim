package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.observer.EventManager;
import org.apache.commons.configuration2.Configuration;

public class FoodPile extends Structure {
    protected FoodPile(EventManager manager, Configuration gameConfig) {
        super(manager, gameConfig);
    }

    @Override
    public String toString() {
        return null;
    }
}
