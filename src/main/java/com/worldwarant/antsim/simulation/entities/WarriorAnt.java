package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import com.worldwarant.antsim.common.observer.SubscriptionException;
import com.worldwarant.antsim.simulation.entities.resources.Resource;
import org.apache.commons.configuration2.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WarriorAnt extends AntBase {

    private final List<Resource> inventory;
    private final Map<String, Integer> capacities;
    public WarriorAnt(Configuration gameConfig) {
        super(gameConfig);
        inventory = new ArrayList<>();
        capacities = GameUtils.parseBySubset(gameConfig, "ants.warrior.capacity");
    }

    @Override
    public void update(String eventType, Object publisher) throws SubscriptionException {
        switch(eventType) {
            case "structure.spaceAvailable": {
                this.handleStructureSpaceAvailable(publisher);
            }

        }
    }

    public void handleStructureSpaceAvailable(Object publisher) throws SubscriptionException {
        if (!(publisher instanceof Structure)) {
            throw new SubscriptionException("Space available event broadcast by unexpected type");
        }
        Structure eventLocation = (Structure)publisher;
        while (!eventLocation.isFull() && !inventory.isEmpty()) {
            eventLocation.accept(this.deposit());
        }
    }

    @Override
    public void move() {

    }

    private Resource deposit() {
        return inventory.remove(0);
    }



    public <T extends Resource> boolean tryGather(T resourceToTake) {
        Class<? extends Resource> type = resourceToTake.getClass();
        if (availableSlots(type) > 0) {
            gather(resourceToTake);
            return true;
        }
        return false;
    }

    private <T extends Resource> void gather(T resourceToTake) {
        inventory.add(resourceToTake);
    }

    public int availableSlots(Class<? extends Resource> type) {
        int available = this.getCapacity(type) - getCount(type);
        return available;
    }

    private int getCount(Class<? extends Resource> type) {
        return (int)inventory.stream().filter(type::isInstance).count();
    }

    private int getCapacity(Class<? extends Resource> type) {
        String typeName = type.getSimpleName();
        return getCapacity(typeName.toLowerCase());
    }

    private int getCapacity(String key) {
        return capacities.get(key.toLowerCase());
    }

    @Override
    public String toString() {
        return null;
    }
}
