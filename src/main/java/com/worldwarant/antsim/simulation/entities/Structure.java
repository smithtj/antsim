package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.observer.EventManager;

public class Structure {
    private final EventManager eventManager;

    public Structure(EventManager manager) {
        this.eventManager = manager;
    }
}
