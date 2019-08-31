package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import com.worldwarant.antsim.common.RandomUtils;
import org.apache.commons.configuration2.Configuration;

import java.util.Map;

public class QueenAnt extends AntBase {

    private final Map<String, Integer> devourSpeedsInSeconds;
    public QueenAnt(Configuration gameConfig) {
        super(gameConfig);
        devourSpeedsInSeconds = GameUtils.parseBySubset(gameConfig, "ants.queen.devourSpeedInSeconds");
    }

    @Override
    public void update(String eventType, Object subscriber) {

    }

    public void devour() {
        int speedInSeconds = getRandomSpeedInSeconds();
    }

    private int getRandomSpeedInSeconds() {
        return RandomUtils.getRandomInRange(devourSpeedsInSeconds.get("min"), devourSpeedsInSeconds.get("max"));
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return null;
    }
}
