package Assignments.A1.Shapes;

import java.util.ArrayList;

/**
 * Demonstrates the creation and handling of various shapes.
 * The main method generates shapes, handles any exceptions, and prints the description of each shape.
 * 
 * @throws InvalidShapeParameterException if any shape has invalid parameters.
 */
public class FunWithShapes {
    
    /**
     * The entry point of the application.
     * Generates 10 shapes using the ShapeGenerator, handles exceptions, and prints the description of each valid shape.
     *
     * @param args Command line arguments (not used).
     * @throws InvalidShapeParameterException if any shape has invalid parameters.
     */
    public static void main(String[] args) throws InvalidShapeParameterException {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        
        // Generate 10 shapes and handle any invalid shape parameter exceptions.
        for (int x = 0; x < 10; x++) {
            try {
                Shape shape = ShapeGenerator.getShape();
                if (shape != null) {
                    shapes.add(shape);
                }
            } catch (InvalidShapeParameterException e) {
                System.err.println(e);
            }
        }

        // Print the description of each valid shape.
        for (Shape shape : shapes) {
            System.out.println(shape.getDescription());
        }
    }
}
