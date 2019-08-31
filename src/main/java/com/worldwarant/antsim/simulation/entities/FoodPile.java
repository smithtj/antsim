package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import com.worldwarant.antsim.common.RandomUtils;
import com.worldwarant.antsim.common.observer.EventManager;
import com.worldwarant.antsim.simulation.entities.resources.Resource;
import org.apache.commons.configuration2.Configuration;

import java.util.ArrayList;
import java.util.List;

public class FoodPile extends Structure {
    private final int capacity;
    private final List<Resource> inventory;

    protected FoodPile(EventManager manager, Configuration gameConfig) {
        super(manager, gameConfig);
        capacity = GameUtils.parseBySubset(gameConfig, "foodPile").get("capacity");
        inventory = new ArrayList<>();
    }

    @Override
    public String toString() {
        return null;
    }

    public boolean isFull() {
        return inventory.size() >= capacity;
    }

    public <T extends Resource> void deposit(T resourceToDeposit) {
        inventory.add(resourceToDeposit);
    }

    public Resource take() {
        return inventory.remove(RandomUtils.getRandomInRange(inventory.size()));
    }
}
