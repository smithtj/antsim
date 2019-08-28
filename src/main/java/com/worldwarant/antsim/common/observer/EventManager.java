package com.worldwarant.antsim.common.observer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class EventManager {
    private static final Logger logger = LogManager.getLogger(EventManager.class);

    Map<String, List<EventListener>> subscribers = new HashMap<>();

    public EventManager(String... antOperations) {
        Arrays.asList(antOperations)
                .forEach(antOp -> this.subscribers.put(antOp, new ArrayList<EventListener>()));
    }

    public void notify(String eventType, Object source) {
        getSubscribersByType(eventType)
                   .forEach(sub -> sub.update(eventType, source));
    }

    public void subscribe(String eventType, EventListener listener) {
        getSubscribersByType(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        getSubscribersByType(eventType).remove(listener);
    }

    private List<EventListener> getSubscribersByType(String eventType) throws IllegalArgumentException {
        if (eventType == null || eventType.isEmpty()) {
            String message = "Null or empty eventType passed to getSubscribersByType.";
            logger.log(Level.ERROR, message);
            throw new IllegalArgumentException(message);
        }
        if (!subscribers.containsKey(eventType)) {
            String message = String.format("eventType %s not found in subscribers.", eventType);
            logger.log(Level.ERROR, message);
            throw new IllegalArgumentException(message);
        }
        return subscribers.get(eventType);
    }
}
