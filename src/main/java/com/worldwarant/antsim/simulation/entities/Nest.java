package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.observer.EventManager;
import com.worldwarant.antsim.simulation.entities.resources.Egg;
import com.worldwarant.antsim.simulation.entities.resources.Remains;
import com.worldwarant.antsim.simulation.entities.resources.Resource;
import com.worldwarant.antsim.simulation.entities.resources.Vegetation;
import org.apache.commons.configuration2.Configuration;

import java.util.Arrays;
import java.util.List;

public class Nest {
    public List<? super Structure> nestStructures;
    private final Configuration gameConfig;

    public Nest(Configuration gameConfig) {
        this.gameConfig = gameConfig;
        initialiseNest();
    }

    private void initialiseNest() {
        nestStructures.add(new FoodPile(new EventManager(), gameConfig));
        nestStructures.add(new Chamber<>(new EventManager(), gameConfig, Egg.class));
        nestStructures.add(new Chamber<>(new EventManager(), gameConfig, Vegetation.class));
        nestStructures.add(new Chamber<>(new EventManager(), gameConfig, Remains.class));
    }
}
