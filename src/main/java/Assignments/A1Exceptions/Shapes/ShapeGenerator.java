package Assignments.A1Exceptions.Shapes;

import java.util.Random;

/**
 * Generates random shapes.
 * 
 * This class provides a static method to generate random shapes, either circles or rectangles.
 * 
 * @see Circle
 * @see Rectangle
 */
public class ShapeGenerator {
    /**
     * Generates a random shape (either Circle or Rectangle).
     * 
     * @return A randomly generated shape.
     * @throws InvalidShapeParameterException if the generated shape has invalid parameters.
     */
    static Shape getShape() throws InvalidShapeParameterException {
        Random rand = new Random();
        if (rand.nextInt() % 2 == 0) {
            // Reserve space for the circle object to keep it in scope.
            Circle circle = null;
            try {
                circle = new Circle(rand.nextDouble(-1, 1));
            } catch (InvalidShapeParameterException e) {
                System.err.println(e);
            }
            return circle;
        } else {
            Rectangle rectangle = null;
            try {
                rectangle = new Rectangle(rand.nextDouble(-1, 1), rand.nextDouble(1, 10));
            } catch (InvalidShapeParameterException e) {
                System.err.println(e);
            }
            return rectangle;
        }
    }
}
