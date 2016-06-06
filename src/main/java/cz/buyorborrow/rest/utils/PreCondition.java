package cz.buyorborrow.rest.utils;

/**
 * This class provides utility static methods that are used to ensure that a method or a constructor
 * was invoked properly.
 * These methods throw an exception if specified precondition is violated.
 * Created by ekishigo on 30.3.16.
 */
public class PreCondition {

    /**
     * Ensures that the expression given as a method parameter is true.
     * @param expression Inspected expression.
     * @param errorMsgTemplate Template of error message, used to construct the formatted string.
     * @param errorMsgArgs Arguments for error message template.
     * @throws IllegalArgumentException if the inspected exception is false.
     */
    public static void isTrue(boolean expression, String errorMsgTemplate, Object... errorMsgArgs) {
        isTrue(expression, String.format(errorMsgTemplate, errorMsgArgs));
    }

    /**
     * Ensures that the expression given as a method parameter is free.
     * @param expression inspected expression.
     * @param errorMsg error message which is passed to the exception.
     * @throws IllegalArgumentException if the inspected expression false.
     */
    public static void isTrue(boolean expression, String errorMsg) {
        if (!expression) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /**
     * Ensures that the string given as a method parameter is not empty.
     * @param string inspected string.
     * @param errorMsg error message which is passed to the exception.
     * @throws IllegalArgumentException if the inspected string is empty.
     */
    public static void notEmpty(String string, String errorMsg) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /**
     * Ensures that the reference to an object given as a method parameter is not null.
     * @param reference the inspected reference.
     * @param errorMsg error message which is passed to the exception.
     * @throws NullPointerException if the inspected reference to an object is null.
     */
    public static void notNull(Object reference, String errorMsg) {
        if (reference == null) {
            throw new NullPointerException(errorMsg);
        }
    }
}
