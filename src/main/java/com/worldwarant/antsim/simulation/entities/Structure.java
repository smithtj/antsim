package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.RandomUtils;
import com.worldwarant.antsim.common.observer.EventManager;
import com.worldwarant.antsim.simulation.entities.resources.Resource;
import org.apache.commons.configuration2.Configuration;

import java.util.List;

public abstract class Structure extends EntityBase {
    protected final EventManager eventManager;

    protected final int capacity;
    protected final List<Resource> inventory;

    protected Structure(EventManager manager, Configuration gameConfig, int capacity, List<Resource> inventory) {
        super(gameConfig);
        this.eventManager = manager;
        this.capacity = capacity;
        this.inventory = inventory;
    }

    public boolean isFull() {
        return inventory.size() >= capacity;
    }

    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    public void accept(Resource resourceToDeposit) {
        inventory.add(resourceToDeposit);
    }

    public Resource yield() {
        return inventory.remove(RandomUtils.getRandomInRange(inventory.size()));
    }


}
