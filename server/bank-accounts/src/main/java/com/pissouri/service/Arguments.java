package com.pissouri.service;

/**
 * Static utility methods for basic "primitive" argument validation
 */
final class Arguments {

    /**
     * Throws an {@link IllegalArgumentException} if {@param condition} is not satisfied
     */
    static void must(Object value, boolean condition) {

        if (!condition) throw new IllegalArgumentException(String.format("Invalid argument %s", value));
    }
}
