package com.expense.tracker.expensetrackerapi.util;

import com.expense.tracker.expensetrackerapi.exceptions.ConflictException;
import com.expense.tracker.expensetrackerapi.exceptions.MyResourceNotFoundException;

/**
 * Simple static methods to be called at the start of your own methods to verify correct arguments and state. If the Precondition fails, an {@link } code is thrown
 */
public final class RestPreconditions {
    private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @throws MyResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression) {
        if (!expression) {
            throw new MyResourceNotFoundException();
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param resource
     *            has value true if found, otherwise false
     * @throws MyResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new MyResourceNotFoundException("Not found");
        }

        return resource;
    }

    public static void checkExist(final boolean expression){
        if(expression)
            throw new ConflictException("Already exist");

    }

}
