package Assignments.A1Exceptions.Shapes;

import Assignments.A1Exceptions.InvalidShapeParameterException;

import java.util.ArrayList;

public class FunWithShapes {
    public static void main(String[] args) throws InvalidShapeParameterException {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        for (int x = 0; x < 10; x++) {
            Shape shape = ShapeGenerator.getShape();
            shapes.add(shape);
        }

        for (Shape shape : shapes) {
            System.out.println(shape.getDescription());
        }
    }
}
