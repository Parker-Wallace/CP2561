package Assignments.A1.Shapes;

/**
 * Exception thrown when a shape parameter is invalid.
 * 
 * This exception is thrown specifically in scenarios where a shape's parameter does not meet
 * the required criteria, such as a non-positive radius for a circle.
 * 
 * @see Exception
 */
public class InvalidShapeParameterException extends Exception {
    /**
     * The default message for this exception.
     */
    public static final String msg = "Shape Parameter is not Valid!";

    /**
     * Constructs a new InvalidShapeParameterException with the default error message.
     */
    public InvalidShapeParameterException() {
        super(msg);
    }
}
