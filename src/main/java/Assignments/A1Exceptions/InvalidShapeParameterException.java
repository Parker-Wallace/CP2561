package Assignments.A1Exceptions;

public class InvalidShapeParameterException extends Exception {
    public static final String msg = "Shape Parameter is not Valid!";

    public InvalidShapeParameterException() {
        super(msg);
    }
}

