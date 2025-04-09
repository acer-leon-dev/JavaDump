package com.lacer.patterns;

/**
 * A specialization of TrackValue for the Double class.
 */
public class TrackedDouble extends Tracked<Double> {
    /**
     * Constructs a new TrackDouble
     */
    public TrackedDouble() {
        current_value = 0.0;
    }

    /**
     *
     * @param value The value to initialize the current value with.
     */
    public TrackedDouble(double value) {
        current_value = value;
    }

    /**
     * Sets the current value to value.
     */
    public void set(double value) {
        last_value = current_value;
        current_value = value;
    }
}
