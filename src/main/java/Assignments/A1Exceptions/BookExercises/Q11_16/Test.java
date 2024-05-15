package Assignments.A1Exceptions.BookExercises.Q11_16;

/**
 * The {@Test} class demonstrates catching exceptions with superclasses
 */
public class Test {

    /**
     * The main method in the program.
     */
    public static void main(String[] args) {
        try {
            throw new ExceptionB("Throws Exception B");
        }
        catch (ExceptionA e) {
            System.err.println(e);
        }
        try {
            throw new ExceptionC("Throws Exception C");
        }
        catch (ExceptionA e) {
            System.err.println(e);
        }
    }
}
