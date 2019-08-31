package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.observer.EventManager;
import com.worldwarant.antsim.simulation.entities.resources.Egg;
import com.worldwarant.antsim.simulation.entities.resources.Remains;
import com.worldwarant.antsim.simulation.entities.resources.Vegetation;
import org.apache.commons.configuration2.Configuration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Nest {
    public List<? super Structure> nestStructures;
    private final Configuration gameConfig;
    private static final Logger logger = LogManager.getLogger(Nest.class);

    public Nest(Configuration gameConfig) {
        this.gameConfig = gameConfig;
        initialiseNest();
    }

    private void initialiseNest() {
        logger.log(Level.DEBUG, "Nest initialising nest structures");
        nestStructures = new ArrayList<>();
        nestStructures.add(new FoodPile(new EventManager(), gameConfig));
        nestStructures.add(new Chamber<>(new EventManager(), gameConfig, Egg.class));
        nestStructures.add(new Chamber<>(new EventManager(), gameConfig, Vegetation.class));
        nestStructures.add(new Chamber<>(new EventManager(), gameConfig, Remains.class));
    }

}
