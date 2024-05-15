package Assignments.A1Exceptions.BookExercises.Q11_16;

/**
 * The {@code ExceptionB} class represents a custom checked exception that extends {@link ExceptionA}.
 * It inherits the behavior of {@code ExceptionA} and can be used to indicate specific errors or conditions within a program.
 */
public class ExceptionB extends ExceptionA {

    /**
     * Constructs a new {@code ExceptionB} with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method).
     */
    public ExceptionB(String message) {
        super(message);
    }
}
