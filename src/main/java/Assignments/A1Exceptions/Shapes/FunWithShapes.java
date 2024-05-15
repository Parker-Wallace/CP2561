package Assignments.A1Exceptions.Shapes;

import java.util.ArrayList;

public class FunWithShapes {
    public static void main(String[] args) throws InvalidShapeParameterException {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        for (int x = 0; x < 10; x++) {
            try {
                Shape shape = ShapeGenerator.getShape();
                if (shape != null) {shapes.add(shape);}
            }
            catch (InvalidShapeParameterException e) {
                System.err.println(e);
            }
        }
        for (Shape shape : shapes) {
            System.out.println(shape.getDescription());
        }
    }
}
