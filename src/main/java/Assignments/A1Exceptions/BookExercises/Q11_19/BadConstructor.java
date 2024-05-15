package Assignments.A1Exceptions.BookExercises.Q11_19;

/**
 * The {@code BadConstructor} class represents an object whose constructor throws a generic Exception.
 */
public class BadConstructor {
    /**
     * Constructs a new {@code BadConstructor} object.
     *
     * @throws Exception for demonstration purposes
     */
    public BadConstructor() throws Exception {
        throw new Exception("Cannot Create Object");
    }
}
