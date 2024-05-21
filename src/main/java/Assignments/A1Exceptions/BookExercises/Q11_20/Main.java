package Assignments.A1Exceptions.BookExercises.Q11_20;

/**
 * Main class for demonstrating exception handling.
 * 
 * This class contains a main method that invokes a method which may throw an exception.
 */
public class Main {
    /**
     * Entry point of the Main application.
     * 
     * Invokes the {@code someMethod} and handles any exceptions thrown.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) throws Exception {
        try {
            someMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls a method that may throw an exception.
     * 
     * @throws Exception if an exception occurs in the called method.
     */
    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Throws a new exception.
     * 
     * @throws Exception always throws an exception with a message "someMethod2 Exception".
     */
    public static void someMethod2() throws Exception {
        throw new Exception("someMethod2 Exception");
    }
}
