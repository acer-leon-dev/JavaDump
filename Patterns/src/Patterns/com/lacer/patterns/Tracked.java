package com.lacer.patterns;

/**
 * A container for a value whose previous value (prior to reassignment) is stored each time it is set.
 * @param <T>
 */
public class Tracked<T> {
    // The current value stored
    protected T current_value;
    // The last value stored before assignment
    protected T last_value = null;

    /**
     * Constructs a new TrackedValue of type T, initializing the current value to null.
     */
    public Tracked() {
        current_value = null;
    }

    /**
     * Constructs a TrackedValue of type T, initializing the current value to value.
     */
    public Tracked(T value) {
        current_value = value;
    }

    /**
     * Sets the current value to value.
     */
    public void set(T value) {
        last_value = current_value;
        current_value = value;
    }

    public T get() {
        return current_value;
    }

    public T getLast() {
        return last_value;
    }
}