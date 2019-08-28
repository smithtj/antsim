package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.simulation.entities.resources.Resource;
import org.apache.commons.configuration2.Configuration;

import java.util.ArrayList;
import java.util.List;

public class WarriorAnt extends AntBase {

    private final List<Resource> inventory;
    private int maxCapacity;
    public WarriorAnt(Configuration gameConfig) {
        super(gameConfig);
        inventory = new ArrayList<>();
        maxCapacity = gameConfig.getInt("ants.warrior.capacity.max");
    }

    @Override
    public void update(String eventType, Object subscriber) {

    }

    @Override
    public void move() {

    }

    public int availableSlots(Class<? extends Resource> type) {
        int available = this.getCapacityFromConfig(type) - getCount(type);
        return available;
    }

    private int getCount(Class<? extends Resource> type) {
        return (int)inventory.stream().filter(type::isInstance).count();
    }

    private int getCapacityFromConfig(Class<? extends Resource> type) {
        String typeName = type.getSimpleName();
        return gameConfig.getInt(String.format("ants.warrior.capacity.%s", typeName));
    }

    @Override
    public String toString() {
        return null;
    }
}
