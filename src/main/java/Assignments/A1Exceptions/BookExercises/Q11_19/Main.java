package Assignments.A1Exceptions.BookExercises.Q11_19;

public class Main {
    public static void main(String[] args) {
        try {
            BadConstructor someobject = new BadConstructor();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
