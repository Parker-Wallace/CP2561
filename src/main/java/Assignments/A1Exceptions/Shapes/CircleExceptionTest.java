package Assignments.A1Exceptions.Shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleExceptionTest {

    @Test
    void createCircles() throws InvalidShapeParameterException {
        Circle circle = new Circle(5.5);
        assertNotNull(circle);

        assertThrows(InvalidShapeParameterException.class, () -> {
            Circle badCircle = new Circle(-5.5);
        });}


    }
