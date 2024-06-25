package Assignments.A1.BookExercises.Q11_16;

/**
 * The {@code ExceptionC} class represents a custom exception that extends @{ExceptionB}.
 * It inherits the behavior of {@code ExceptionB} and can be used to indicate specific errors within a program
 */
public class ExceptionC extends ExceptionB{

    /**
     * Constructs a new {@code ExceptionC} with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method).
     */
    public ExceptionC(String message) {
        super(message);
    }
}
