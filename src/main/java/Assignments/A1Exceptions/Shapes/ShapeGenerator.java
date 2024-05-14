package Assignments.A1Exceptions.Shapes;

import Assignments.A1Exceptions.InvalidShapeParameterException;

import java.util.Random;

public class ShapeGenerator {
    static Shape getShape() throws InvalidShapeParameterException {
        Random rand = new Random();
        if (rand.nextInt() % 2 == 0) {
            return new Circle(rand.nextDouble(-1,1));
        }
        else {
            return new Rectangle(rand.nextDouble(-1,1), rand.nextDouble(1,10));
        }
    }
}
