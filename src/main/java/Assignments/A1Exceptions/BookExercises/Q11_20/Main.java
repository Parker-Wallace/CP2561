package Assignments.A1Exceptions.BookExercises.Q11_20;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            someMethod();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void someMethod() throws Exception {
        try {
        someMethod2();
        }
        catch(Exception e) {
            throw e;
        }
        }

    public static void someMethod2() throws Exception {
        throw new Exception("someMethod2 Exception");
    }
}
