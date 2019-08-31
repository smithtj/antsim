package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import org.apache.commons.configuration2.Configuration;

import java.util.Map;

public class WorkerAnt extends AntBase {
    private final Map<String, Integer> speedValues;

    public WorkerAnt(Configuration gameConfig) {
        super(gameConfig);
        speedValues = GameUtils.parseBySubset(gameConfig, "ants.worker.speedInSeconds");
    }

    @Override
    public void update(String eventType, Object subscriber) {

    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return null;
    }


}
