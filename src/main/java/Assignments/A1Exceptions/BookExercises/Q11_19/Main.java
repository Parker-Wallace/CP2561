package Assignments.A1Exceptions.BookExercises.Q11_19;

 /**
 * The {@code Main} class demonstrates constructor failure.
 */
public class Main {

    /**
     * The main method of the program.
     */
    public static void main(String[] args) {
        try {
            BadConstructor someobject = new BadConstructor();
            System.out.println(someobject);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
