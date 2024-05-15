package Assignments.A1Exceptions.BookExercises.Q11_16;

/**
 * The {@code ExceptionA} class represents a custom checked exception.
 * It extends the {@code Exception} class, indicating that it is a checked exception.
 * This exception is typically thrown to indicate specific errors or conditions within a program.
 */
public class ExceptionA extends Exception {

    /**
     * Constructs a new {@code ExceptionA} with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method).
     */
    public ExceptionA(String message) {
        super(message);
    }
}

