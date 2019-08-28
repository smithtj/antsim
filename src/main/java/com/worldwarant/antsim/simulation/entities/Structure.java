package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.observer.EventManager;
import org.apache.commons.configuration2.Configuration;

public abstract class Structure extends EntityBase {
    protected final EventManager eventManager;

    protected Structure(EventManager manager, Configuration gameConfig) {
        super(gameConfig);
        this.eventManager = manager;
    }


}
