package Assignments.A1Exceptions.BookExercises.Q11_16;

public class Test {
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
