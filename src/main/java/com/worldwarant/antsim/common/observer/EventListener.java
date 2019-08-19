package com.worldwarant.antsim.common.observer;

public interface EventListener {
    void update(String eventType, Object subscriber);
}
