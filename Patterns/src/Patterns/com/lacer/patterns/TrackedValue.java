package com.lacer.patterns;

public class TrackedValue<T> {
    private T current_value;
    private T last_value = null;

    /**
     * Constructs a current_value to T's default value.
     */
    TrackedValue() {}

    /**
     * Constructs a TrackedValue, setting current_value to value.
     */
    TrackedValue(T value) {
        current_value = value;
    }

    /**
     * Sets current_value to value.
     */
    void set(T value) {
        last_value = current_value;
        current_value = value;
    }

    T get() {
        return current_value;
    }

    T getLast() {
        return last_value;
    }
}
