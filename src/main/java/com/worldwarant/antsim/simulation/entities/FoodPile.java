package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import com.worldwarant.antsim.common.RandomUtils;
import com.worldwarant.antsim.common.observer.EventManager;
import com.worldwarant.antsim.simulation.entities.resources.Resource;
import org.apache.commons.configuration2.Configuration;

import java.util.ArrayList;
import java.util.List;

public class FoodPile extends Structure {
    protected FoodPile(EventManager manager, Configuration gameConfig) {
        super(manager, gameConfig, GameUtils.parseBySubset(gameConfig, "foodPile").get("capacity"), new ArrayList<>());
    }

    @Override
    public String toString() {
        return null;
    }
}
