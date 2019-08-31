package com.worldwarant.antsim.simulation;

public class SimulationException extends Throwable {
    public SimulationException(String message) {
        super(message);
    }

    public SimulationException(String message, Exception innerException) {
        super(message, innerException);
    }
}
