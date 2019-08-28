package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.observer.EventListener;
import org.apache.commons.configuration2.Configuration;

public abstract class AntBase extends EntityBase implements EventListener {
    private Structure location;

    public AntBase(Configuration gameConfig) {
        super(gameConfig);
    }

    public Structure getLocation() {
        return location;
    }

    public void setLocation(Structure location) {
        this.location = location;
    }

    public abstract void move();
}
