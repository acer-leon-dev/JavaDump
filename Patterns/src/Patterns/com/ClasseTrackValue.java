package com.lacer.patterns;

public class TrackedValue<T> {
    T current_value;
    T last_value = null;

    TrackedValue() {}

    TrackedValue(T value) {
        current_value = value;
    }

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
