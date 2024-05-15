package Assignments.A1Exceptions.Shapes;

import java.util.Random;

public class ShapeGenerator {
    static Shape getShape() throws InvalidShapeParameterException {
        Random rand = new Random();
        if (rand.nextInt() % 2 == 0) {
            // reserve space for the circle object such that in can be instantiated in the try block and returned
            // reserving the memory keeps it in scope of the if else
            Circle circle = null;
            try {
                circle =  new Circle(rand.nextDouble(-1,1));
            }
            catch (InvalidShapeParameterException e) {
                System.err.println(e);
            }
            return circle;
        }
        else {
            Rectangle rectangle = null;
            try {
                rectangle = new Rectangle(rand.nextDouble(-1,1), rand.nextDouble(1,10));
            }
            catch (InvalidShapeParameterException e) {
                System.err.println(e);
            }
            return rectangle;
        }
    }
}
