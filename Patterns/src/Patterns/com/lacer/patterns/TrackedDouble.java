package com.lacer.patterns;

/**
 * A specialization of TrackedValue for the Double class.
 * Enables constructing and setting a TrackedValue<Double> from a primitive double.
 */
public class TrackedDouble extends TrackedValue<Double> {
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
     * Sets the current value from a given value.
     *
     * @param value The value to assign from.
     */
    public void set(double value) {
        last_value = current_value;
        current_value = value;
    }
}
