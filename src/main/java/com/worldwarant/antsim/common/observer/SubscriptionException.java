package com.worldwarant.antsim.common.observer;

public class SubscriptionException extends Throwable {
    public SubscriptionException(String message) {
        super(message);
    }

    public SubscriptionException(String message, Exception innerException) {
        super(message, innerException);
    }
}
